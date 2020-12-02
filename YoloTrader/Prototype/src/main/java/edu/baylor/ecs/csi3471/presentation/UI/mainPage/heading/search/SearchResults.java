package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * UI class responsible for displays the results from the API query
 * @author owenmurphy
 */
public class SearchResults {

    /** panel holding the everything from teh results of the query */
    public static JPanel searchPanel;

    /** add stock button for stock selected */
    public static JButton addStockButton;

    /** open graph and analysis of the selected stock */
    public static JButton openStockButton;

    /** displays the stock model */
    public static JList<String> stockList;

    /** contains the names of the stocks */
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

    /**
     * @return JScrollPane to scroll through the stocks returned from the query to API
     */
    public static JScrollPane getScrollPane() {

        setStockList(new JList<>(getStockModel()));

        return new JScrollPane(getStockList());
    }

    /**
     * @return the search results containing the results from the query
     */
    public static JPanel getSearchPanel() {
        searchPanel = new JPanel(new BorderLayout());

        // setting and adding the label
        searchPanel.add(new JLabel("<html><span style=\"font-family:Arial;font-size:16px;\"><B>Results:</B>",
                JLabel.CENTER), BorderLayout.NORTH);

        // adding the scroll pane containing the list and model
        searchPanel.add(getScrollPane(), BorderLayout.CENTER);

        // add button panel to the bottom of pane
        searchPanel.add(getButtonPanel(), BorderLayout.SOUTH);

        return searchPanel;
    }

    /**
     * button panel holds the 'add' and 'open' stock buttons
     * @return JPanel with the buttons
     */
    public static JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));  // initialize the panel
                                                                           // with gridlayout

        // adding 'add stock' button
        setAddStockButton(new JButton("Add Stock"));
        buttonPanel.add(getAddStockButton());

        // adding the 'open stock' button
        setOpenStockButton(new JButton("Open Stock"));
        buttonPanel.add(getOpenStockButton());

        return buttonPanel;
    }

    /**
     * set the stock JList
     * @param stockList JList to be set to
     */
    public static void setStockList(JList<String> stockList) { SearchResults.stockList = stockList; }

    /**
     * @return the sotck JList
     */
    public static JList<String> getStockList() { return stockList; }

    /**
     * set the stock model
     * @param stockModel stock model to be set to
     */
    public static void setStockModel(ListModel<String> stockModel) { SearchResults.stockModel = stockModel; }

    /**
     * @return the stockModel containing the names of the stocks
     */
    public static ListModel<String> getStockModel() { return stockModel; }

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
    public static JButton getAddStockButton() { return addStockButton; }

    /**
     * @return the open stock JButton
     */
    public static JButton getOpenStockButton() { return openStockButton; }

    /**
     * sets the stock button to parameter passed in and adds the listener
     * @param openStockButton stock button to be set to
     */
    public static void setOpenStockButton(JButton openStockButton) {
        SearchResults.openStockButton = openStockButton;

        // adding listener  for when button pressed
        openStockButton.addActionListener(NorthPanelController.getOpenStockButtonListener());
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
    public static void getStockAddedSuccessfullyMessage() { JOptionPane.showMessageDialog(null, "Stock was added successfully"); }

    /**
     * display errors to user saying the stock has already been added to the list wanted to add to
     */
    public static void getStockAlreadyAddedWarning() { JOptionPane.showMessageDialog(null, "Stock already added", "Warning", JOptionPane.WARNING_MESSAGE); }
}
