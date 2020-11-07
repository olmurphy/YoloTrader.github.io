package edu.baylor.ecs.csi3471.UI.heading.search;

import javax.swing.*;
import java.awt.*;

public class Search {



    public static JTextField searchTextField;
    public static JButton searchButton;
    public static JPanel searchStockPanel;

    public static JPanel getSearchStockPanel() {
        searchStockPanel = new JPanel(new BorderLayout());

        searchStockPanel.add(getSearchTextField(), BorderLayout.CENTER);
        searchStockPanel.add(getSearchButton(), BorderLayout.EAST);

        return searchStockPanel;
    }

    public static JTextField getSearchTextField() {
        searchTextField = new JTextField();

        // FIXME: need to add action

        return searchTextField;
    }

    public static JButton getSearchButton() {
        searchButton = new JButton("Search");

        return searchButton;
    }

    public static JLabel getSearchLabel() {
        JLabel searchLabel = new JLabel("Enter stock name to search", JLabel.LEFT);



        return searchLabel;
    }


}
