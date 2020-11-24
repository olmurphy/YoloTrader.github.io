package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

public class SearchResults {

    public static JPanel searchPanel;

    /** add stock button for stock selected */
    public static JButton addStockButton;

    public static JList<String> stockList;

    public static ListModel<String> stockModel;

    /**
     * main dialog that displays the company names from the result of the search
     */
    public static void startSearchDialog() {

        JDialog dialog = new JDialog();
        dialog.add(getSearchPanel());

        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLocationRelativeTo(null);     // centers the frame in the middle of the screen
                                                // regardless of the dual monitor setup
        dialog.pack();                          // optimal if application is running on different computers
        dialog.setVisible(true);                // let the user see the frame once it is fully setup
    }

    public static JScrollPane getScrollPane() {

        setStockList(new JList<>(getStockModel()));

        return new JScrollPane(getStockList());
    }

    public static JPanel getSearchPanel() {
        searchPanel = new JPanel(new BorderLayout());

        // setting and adding the label
        searchPanel.add(new JLabel("<html><span style=\"font-family:Arial;font-size:16px;\"><B>Results:</B>",
                JLabel.CENTER), BorderLayout.NORTH);

        // adding the scroll pane containing the list and model
        searchPanel.add(getScrollPane(), BorderLayout.CENTER);

        // add 'add stock' button to the bottom of pane
        setAddStockButton(new JButton("Add Stock"));
        searchPanel.add(getAddStockButton(), BorderLayout.SOUTH);

        return searchPanel;
    }

    public static void setStockList(JList<String> stockList) {
        SearchResults.stockList = stockList;
    }

    public static JList<String> getStockList() {
        return stockList;
    }

    public static void setStockModel(ListModel<String> stockModel) {
        SearchResults.stockModel = stockModel;
    }

    public static ListModel<String> getStockModel() {
        return stockModel;
    }

    /**
     * sets the add stock button and adds the listener
     * @param addStockButton JButton for the add stock button
     */
    public static void setAddStockButton(JButton addStockButton) {
        SearchResults.addStockButton = addStockButton;

        // adding the listener for when button pressed
        addStockButton.addActionListener(NorthPanelController.getAddStockButtonListener());
    }

    /**
     * @return add stock button for when user wants to add a stock
     */
    public static JButton getAddStockButton() {
        return addStockButton;
    }

    /**
     * displays warning that no results showed from the query of searching the stock
     */
    public static void getNoResultsWarning() {
        JOptionPane.showMessageDialog(null, "No results found.",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * pulls a input dialog asking for the user to input the name of the watch list they wnat to create
     * @return name of stock watch list from user
     */
    public static String getInputWatchListNameToAdd() {
        return JOptionPane.showInputDialog(null, "input the watchlist name",
                "Input Window", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * displays a warning to the user saying no stock is selected for trying to add a stock
     */
    public static void getNoStockSelectedWarning() {
        JOptionPane.showMessageDialog(null, "no stock selected",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * displays error if the input name for the watch list does not exist
     */
    public static void getListNotExistWarning() {
        JOptionPane.showMessageDialog(null, "not watch list exists",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * displays successful message that the stock was added successfully
     */
    public static void getStockAddedSuccessfullyMessage() {
        JOptionPane.showMessageDialog(null, "Stock was added successfully");
    }

    /**
     * display errors to user saying the stock has already been added to the list wanted to add to
     */
    public static void getStockAlreadyAddedWarning() {
        JOptionPane.showMessageDialog(null, "Stock already added", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
