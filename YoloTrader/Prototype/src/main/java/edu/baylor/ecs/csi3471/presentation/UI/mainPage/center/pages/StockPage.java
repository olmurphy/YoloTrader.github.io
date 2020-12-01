package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.pages;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.model.Comment;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.GraphPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owenmurphy
 */
public class StockPage {

    public static JDialog dialog;
    public static JTabbedPane stockTabbedPane;
    public static JPanel commentPanel;
    public static JPanel stockPanel;

    public static void startStockPage() {
        dialog = new JDialog();
        dialog.addWindowListener(getDialogWindowListener());
        dialog.setBackground(CenterPanelController.centerPanelColor);

        // setting and adding tabbed pane
        setStockTabbedPane(new JTabbedPane());
        dialog.add(getStockTabbedPane());

        dialog.pack();                          // optimal if application is running on different computers
        dialog.setLocationRelativeTo(MainPanel.getMainPanel());         // centers the frame in the middle of the screen
                                                // regardless of the dual monitor setup
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);                // let the user see the frame once it is fully setup
    }

    public static void setStockTabbedPane(JTabbedPane stockTabbedPane) { StockPage.stockTabbedPane = stockTabbedPane; }

    public static JTabbedPane getStockTabbedPane() { return stockTabbedPane; }

    public static void addStockToPanel(Stock stock) {

        yahoofinance.Stock equity = StockUtil.getStock(stock.getTicker());
        String analysis = StockUtil.getAnalysis(equity);

        if (dialog == null) { startStockPage(); }

        stockPanel = new JPanel();
        stockPanel.setLayout(new BoxLayout(stockPanel, BoxLayout.Y_AXIS));
        stockPanel.setBackground(CenterPanelController.centerPanelColor);

        stockPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:20px;\"><B>" + stock.getName() + "</B></span></html>"),
                BorderLayout.CENTER);

        JLabel date = new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:14px;\"><B>Date Added: " + stock.getDateAdded().toString() +
                "</B></span><hr></html>", JLabel.LEFT);
        date.setAlignmentX(Component.LEFT_ALIGNMENT);
        stockPanel.add(date);

        GraphPanel graphPanel = StockUtil.getGraph(equity);
        graphPanel.setPreferredSize(new Dimension(900, 700));
        stockPanel.add(graphPanel);

        // adding daily quote
        stockPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:20px;\"><B>Daily Quote" +
                "</B></span><hr></html>", JLabel.LEFT));
        stockPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;\">" + StockUtil.getQuote(equity) + "</span></html>"));

        stockPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:20px;\"><B>Analysis</B></span><hr></html>"),
                BorderLayout.CENTER);
        stockPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:20px;\"><B>" + analysis + "</B></span></html>"),
                BorderLayout.CENTER);

        // adding news stuff
        stockPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:20px;\"><B>Daily News" +
                "</B></span><hr></html>", JLabel.LEFT));
        JScrollPane newsPanel = StockUtil.getNewsPanel(equity).getNewsScrollPane();
        JPanel newsFeed = new JPanel();
        newsFeed.setPreferredSize(new Dimension(1150, 700));
        newsFeed.setBackground(CenterPanelController.centerPanelColor);

        newsFeed.setLayout(new BoxLayout(newsFeed, BoxLayout.Y_AXIS));
        newsFeed.add(newsPanel);

        stockPanel.add(newsFeed);

        JScrollPane feed = new JScrollPane(stockPanel);

        stockTabbedPane.addTab(stock.getName(), feed);
    }

    public static void setCommentPanel(Stock stock) {

        commentPanel = new JPanel();
        commentPanel.setName("Test");
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
        commentPanel.setBackground(CenterPanelController.centerPanelColor);

        // add all the comments if any exist
        if (stock.getComments().size() > 0) {for (Comment comment : stock.getComments()) { commentPanel.add(produceCommentPanel(comment)); }}
    }

    public static JPanel getCommentPanel() { return commentPanel; }

    public static JPanel produceCommentPanel(Comment comment) {
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setBackground(CenterPanelController.centerPanelColor);

        // setting up header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(CenterPanelController.centerPanelColor);

        // adding to header panel
        headerPanel.add(new JLabel(CenterPanelController.leftLabelSide + "Subject: " + comment.getSubject() + CenterPanelController.rightLabelSide));
        headerPanel.add(new JLabel(CenterPanelController.leftLabelSide + "Date Created: " + comment.getDateCreated().toString()
                + CenterPanelController.rightLabelSide));
        headerPanel.add(new JLabel(CenterPanelController.leftLabelSide + "Date Last Updated: " + comment.getDateLastModified().toString()
                + CenterPanelController.rightLabelSide));

        // setting up footer panel
        JPanel footerPanel = new JPanel(new GridLayout(1, 1));
        footerPanel.setBackground(CenterPanelController.centerPanelColor);
        footerPanel.add(getEditCommentButton(comment));

        // add the panels to comment panel
        commentPanel.add(headerPanel, BorderLayout.NORTH);
        commentPanel.add(new JLabel(CenterPanelController.leftLabelSide + comment.getText() + CenterPanelController.rightLabelSide),
                BorderLayout.CENTER);
        commentPanel.add(footerPanel, BorderLayout.SOUTH);

        return commentPanel;
    }

    public static JButton getAddCommentButton() {
        JButton addCommentButton = new JButton(CenterPanelController.leftButtonSide + "Add Comment" + CenterPanelController.rightButtonSide);
        addCommentButton.setBackground(CenterPanelController.centerPanelColor);
        addCommentButton.setBorder(CenterPanelController.emptyButtonBorder);

        // adding action for add button
        addCommentButton.addActionListener(CenterPanelController.getAddCommentButtonAction());

        // adding UI effects for button
        addCommentButton.addMouseListener(CenterPanelController.getGeneralButtonAction(addCommentButton));

        return addCommentButton;
    }

    public static JButton getEditCommentButton(Comment comment) {
        JButton editCommentButton = new JButton(CenterPanelController.leftButtonSide + "Edit" + CenterPanelController.rightButtonSide);
        editCommentButton.setBackground(CenterPanelController.centerPanelColor);
        editCommentButton.setBorder(CenterPanelController.emptyButtonBorder);

        // adding action for edit button
        editCommentButton.addActionListener(CenterPanelController.getEditCommentButtonAction(comment));

        // adding UI effects for button
        editCommentButton.addMouseListener(CenterPanelController.getGeneralButtonAction(editCommentButton));

        return editCommentButton;
    }

    public static WindowAdapter getDialogWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) { StockPage.dialog = null; }
        };
    }
}