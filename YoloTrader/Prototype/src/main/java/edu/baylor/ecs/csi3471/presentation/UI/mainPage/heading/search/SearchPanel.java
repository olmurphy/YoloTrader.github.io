package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class SearchPanel {

    /** panel that contains all panels like ${@link Name#welcomePanel},
     * ${@link Search#searchStockPanel} */
    public static JPanel searchPanel;

    /** @return JPanel will all the listed items in the attribute comments */
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
