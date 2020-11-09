package edu.baylor.ecs.csi3471.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

public class SearchPanel {

    public static JPanel searchPanel;

    public static JPanel getSearchPanel(String name) {
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3, 1));
        searchPanel.add(Name.getWelcomePanel(name));
        searchPanel.add(Search.getSearchLabel());
        searchPanel.add(Search.getSearchStockPanel());
        searchPanel.setBackground(NorthPanelController.northPanelColor);

        return searchPanel;
    }
}
