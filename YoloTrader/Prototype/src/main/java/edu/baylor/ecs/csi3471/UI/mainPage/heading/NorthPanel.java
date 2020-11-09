package edu.baylor.ecs.csi3471.UI.mainPage.heading;

import edu.baylor.ecs.csi3471.UI.mainPage.heading.search.SearchPanel;
import edu.baylor.ecs.csi3471.UI.mainPage.heading.title.CompanyName;

import javax.swing.*;
import java.awt.*;

public class NorthPanel {

    public static JPanel northPanel;

    public static void createNorthPanel(JPanel mainPanel, String name) {
        northPanel = new JPanel(new BorderLayout());

        northPanel.setPreferredSize(new Dimension(NorthPanelController.northPanelWidth, NorthPanelController.northPanelHeight));

        northPanel.add(CompanyName.getTitlePanel(), BorderLayout.WEST);
        northPanel.add(SearchPanel.getSearchPanel(name));

        mainPanel.add(northPanel, BorderLayout.NORTH);
    }
}