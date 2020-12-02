package edu.baylor.ecs.csi3471.presentation.ui.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.ui.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author owenmurphy
 */
public class Search {

    public static JTextField searchTextField;
    public static JButton searchButton;
    public static JPanel searchStockPanel;

    public static JPanel getSearchStockPanel() {
        searchStockPanel = new JPanel(new BorderLayout());

        setSearchTextField(); // setting the search field

        // adding search field, search button
        searchStockPanel.add(getSearchTextField(), BorderLayout.CENTER);
        searchStockPanel.add(getSearchButton(), BorderLayout.EAST);

        searchStockPanel.setBackground(NorthPanelController.northPanelColor); // setting the background color

        return searchStockPanel;
    }

    public static JTextField getSearchTextField() { return searchTextField; }

    public static JButton getSearchButton() {
        searchButton = new JButton(NorthPanelController.leftButtonSide + "Search " +
                NorthPanelController.rightButtonSide);

        searchButton.setBackground(NorthPanelController.northPanelColor);
        searchButton.setBorder(NorthPanelController.emptyButtonBorder);
        searchButton.setOpaque(true);

        searchButton.addActionListener(NorthPanelController.getSearchButtonListener(getSearchTextField()));
        searchButton.addMouseListener(NorthPanelController.getGeneralButtonListener(searchButton));

        return searchButton;
    }

    public static JLabel getSearchLabel() {
        return new JLabel(NorthPanelController.leftLabelSide + "Enter stock name to search" +
                NorthPanelController.rightLabelSide, JLabel.LEFT);
    }

    public static void setSearchTextField() { Search.searchTextField = new JTextField(); }

    public static void getSearchWarning() {
        JOptionPane.showMessageDialog(null, "Need to input a stock ticker",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
