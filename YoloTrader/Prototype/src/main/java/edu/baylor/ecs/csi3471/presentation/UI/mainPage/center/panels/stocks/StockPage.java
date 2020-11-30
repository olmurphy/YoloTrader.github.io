package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.model.Comment;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.stockPage.GraphPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class StockPage {

    public static JDialog dialog;
    public static JTabbedPane stockTabbedPane;

    public static void startStockPage() {
        dialog = new JDialog();

        // setting and adding tabbed pane
        setStockTabbedPane(new JTabbedPane());
        dialog.add(getStockTabbedPane());

        dialog.setLocationRelativeTo(null);     // centers the frame in the middle of the screen
        // regardless of the dual monitor setup
        //dialog.pack();                          // optimal if application is running on different computers
        dialog.setVisible(true);                // let the user see the frame once it is fully setup
    }

    public static void setStockTabbedPane(JTabbedPane stockTabbedPane) { StockPage.stockTabbedPane = stockTabbedPane; }

    public static JTabbedPane getStockTabbedPane() { return stockTabbedPane; }

    public static void addStockToPanel(Stock stock) {

        yahoofinance.Stock equity = new yahoofinance.Stock(stock.getTicker());
        equity.setName(stock.getName());

        if (dialog == null) { startStockPage(); }

        JPanel stockPanel = new JPanel();
        stockPanel.setLayout(new BoxLayout(stockPanel, BoxLayout.Y_AXIS));
        stockPanel.setBackground(CenterPanelController.centerPanelColor);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(CenterPanelController.centerPanelColor);
        headerPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:20px;\"><B>" + stock.getName() + "</B></span></html>"),
                BorderLayout.CENTER);
        headerPanel.add(getAddCommentButton(), BorderLayout.EAST);

        stockPanel.add(headerPanel);
        JLabel date = new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:14px;\"><B>Date Added: " + stock.getDateAdded().toString() +
                "</B></span><hr></html>");
        date.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        stockPanel.add(date);

        GraphPanel graphPanel = StockUtil.getGraph(equity);
        graphPanel.setPreferredSize(new Dimension(900, 700));
        stockPanel.add(graphPanel);
        JPanel panel = getComments(stock);
        stockPanel.add(panel);
        stockPanel.remove(panel);

        JScrollPane feed = new JScrollPane(stockPanel);

        stockTabbedPane.addTab(stock.getName(), feed);
    }

    public static JPanel getComments(Stock stock) {

        JPanel commentPanel = new JPanel();
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
        commentPanel.setBackground(CenterPanelController.centerPanelColor);

        // add all the comments if any exist
        // if (stock.getComments().size() > 0) {for (Comment comment : stock.getComments()) { commentPanel.add(produceCommentPanel(comment)); }}

        for (int i = 0; i < 20; i++) {
            commentPanel.add(new JLabel("<html><span style=\"font-family:Futura;color:white;font-size:30px;\"><B>TEST:</B></span><hr></html>"));
        }

        return commentPanel;
    }

    public static JPanel produceCommentPanel(Comment comment) {
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setBackground(CenterPanelController.centerPanelColor);

        // setting up footer panel
        JPanel footerPanel = new JPanel(new GridLayout(1, 1));
        footerPanel.setBackground(CenterPanelController.centerPanelColor);
        footerPanel.add(getEditCommentButton(comment));

        // setting up header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(CenterPanelController.centerPanelColor);

        // adding to header panel
        headerPanel.add(new JLabel("Subject: " + comment.getSubject()));
        headerPanel.add(new JLabel("Date Created: " + comment.getDateCreated().toString()));
        headerPanel.add(new JLabel("Date Last Updated: " + comment.getDateLastModified().toString()));


        commentPanel.add(headerPanel, BorderLayout.NORTH);
        commentPanel.add(new JLabel(comment.getText()), BorderLayout.CENTER);
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

    /**
     * displays warning if the user has not selected watch list to perform an action on
     */
    public static void getNoWatchListSelectedWarning() {
        JOptionPane.showMessageDialog(null, "Need to select a watchList to add to",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void getNoStockSelectedWarning() {
        JOptionPane.showMessageDialog(null, "No stock is selected to delete",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static String getAddStockInputDialog() {
        return JOptionPane.showInputDialog(null, "Enter stock name to search",
                "Add Stock", JOptionPane.QUESTION_MESSAGE);
    }


}