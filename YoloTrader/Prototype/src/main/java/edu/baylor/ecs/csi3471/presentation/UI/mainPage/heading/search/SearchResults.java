package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

public class SearchResults {

    public static JPanel searchPanel;

    /** add stock button for stock selected */
    public static JButton addStockButton;

    public static JList stockList;

    public static ListModel<String> stockModel;

    public static int width = 300;
    public static int height = 400;

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

        setStockList(new JList(getStockModel()));

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

    public static void setStockList(JList stockList) {
        SearchResults.stockList = stockList;
    }

    public static JList getStockList() {
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

        // adding the listener
        addStockButton.addActionListener(NorthPanelController.getAddStockButtonListener());
    }

    public static JButton getAddStockButton() {
        return addStockButton;
    }

    public static void getNoResultsWarning() {
        JOptionPane.showMessageDialog(null, "No results found.",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static String getInputWatchListNameToAdd() {
        return JOptionPane.showInputDialog(null, "input the watchlist name",
                "Input Window", JOptionPane.QUESTION_MESSAGE);
    }

    public static void getNoStockSelectedWarning() {
        JOptionPane.showMessageDialog(null, "no stock selected",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
