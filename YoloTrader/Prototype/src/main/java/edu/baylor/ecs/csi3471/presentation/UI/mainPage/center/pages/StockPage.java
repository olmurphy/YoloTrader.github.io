package edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.pages;

import edu.baylor.ecs.csi3471.api.StockUtil;
import edu.baylor.ecs.csi3471.model.Comment;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.ui.stockPage.GraphPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * class displays the stockPage
 * @author owenmurphy
 */
public class StockPage {

    /** holds the stock page on the dialog */
    public static JDialog dialog;

    /** each tab is a stock with the corresponding stock page on it */
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
        String quote = StockUtil.getQuote(equity);
        quote = parseQuote(quote.split(", "));

        if (dialog == null) { startStockPage(); }

        JPanel stockNamePanel = new JPanel(new BorderLayout());
        stockNamePanel.setBackground(CenterPanelController.centerPanelColor);
        stockPanel = new JPanel();
        stockPanel.setLayout(new BoxLayout(stockPanel, BoxLayout.Y_AXIS));
        stockPanel.setBackground(CenterPanelController.centerPanelColor);
        stockNamePanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:25px;\"><B>" + stock.getName() + "</B></span></html>"),
                BorderLayout.WEST);
        stockPanel.add(stockNamePanel);

        JPanel datePanel = new JPanel(new BorderLayout());
        datePanel.setBackground(CenterPanelController.centerPanelColor);
        JLabel date = new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:14px;\"><B>Date Added: " + stock.getDateAdded().toString() +
                "</B></span><hr></html>", JLabel.LEFT);

        date.setAlignmentX(Component.LEFT_ALIGNMENT);
        datePanel.add(date, BorderLayout.WEST);
        stockPanel.add(datePanel);

        GraphPanel graphPanel = StockUtil.getGraph(equity);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(CenterPanelController.centerPanelColor);
        JLabel header = new JLabel("Price vs. Time", JLabel.CENTER);
        header.setForeground(graphPanel.getLineColor());
        header.setFont(new Font("Futura", Font.PLAIN, 50));
        header.setBorder(new EmptyBorder(50, 0, 0, 0));
        header.setAlignmentX(JLabel.CENTER);
        panel.add(header, BorderLayout.CENTER);

        stockPanel.add(panel);

        graphPanel.setPreferredSize(new Dimension(900, 700));
        stockPanel.add(graphPanel);

        stockPanel.add(Box.createRigidArea(new Dimension(0, 75)));

        JPanel dailyQuotePanel = new JPanel();
        dailyQuotePanel.setBackground(CenterPanelController.centerPanelColor);

        // adding daily quote
        assert analysis != null;
        JLabel label = new JLabel("<html><center><span style=\"font-family:Futura;color:white;font-size:25px;\"><B>[ Daily Quote ]</B></span></center><br>" +
                quote +
                "<br><br><br><br><br>" +
                "<center><span style=\"font-family:Futura;color:white;font-size:25px;\"><B>[ Analysis ]</B></span></center><br>" +
                "<center><span style=\"font-family:Futura;font-size:17;color:" + parseAnalysis(analysis) + ";\">" + analysis + "</span></center>" +
                "<br><br><br><br><br>" +
                "<center><span style=\"font-family:Futura;color:white;font-size:25px;\"><B>[ Daily News ]</B></span></center><br>" +
                "</html>");
        label.setAlignmentX(JLabel.CENTER);
        dailyQuotePanel.add(label);
        stockPanel.add(dailyQuotePanel);

        JScrollPane newsPanel = StockUtil.getNewsPanel(equity).getNewsScrollPane();
        newsPanel.setBorder(BorderFactory.createEmptyBorder());
        newsPanel.setBackground(CenterPanelController.centerPanelColor);
        newsPanel.setPreferredSize(new Dimension(1150, 700));

        JPanel newsFeed = new JPanel();

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

    public static String parseAnalysis(String analysis) {  // "Buy/Calls" "Sell/Puts" "Hold/Watch"
        if (analysis.toLowerCase().equals("buy/calls")) { return "green"; }
        else if (analysis.toLowerCase().equals("sell/puts")) { return "red"; }
        return "yellow";
    }

    public static String parseQuote(String []split) {
        StringBuilder stringBuilder = new StringBuilder("<center><ul style=\"list-style-type:none;\">");

        for (String str : split) { stringBuilder.append("<li style=color:white;font-family:Futura;font-size:17px;>").append(str).append("</li>"); }

        return stringBuilder.append("</ul></center>").toString();
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

    /**
     * sets the dialog to null if window closes
     * @return WindowAdapter that listens for when the dialog window closes */
    public static WindowAdapter getDialogWindowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) { StockPage.dialog = null; }
        };
    }
}