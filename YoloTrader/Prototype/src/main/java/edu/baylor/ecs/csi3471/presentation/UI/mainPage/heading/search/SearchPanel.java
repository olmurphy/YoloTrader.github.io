package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

public class SearchPanel {

    public static JPanel searchPanel;

    public static JPanel getSearchPanel() {
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(3, 1));
        searchPanel.add(Name.getWelcomePanel());
        searchPanel.add(Search.getSearchLabel());
        searchPanel.add(Search.getSearchStockPanel());
        searchPanel.setBackground(NorthPanelController.northPanelColor);

        return searchPanel;
    }
}
