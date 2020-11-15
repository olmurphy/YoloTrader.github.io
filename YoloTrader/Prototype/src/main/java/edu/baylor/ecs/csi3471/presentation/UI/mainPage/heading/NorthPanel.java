package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.SearchPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.title.CompanyName;

import javax.swing.*;
import java.awt.*;

public class NorthPanel {

    public static JPanel northPanel;

    public static void createNorthPanel(JPanel mainPanel) {
        northPanel = new JPanel(new BorderLayout());

        northPanel.setPreferredSize(new Dimension(NorthPanelController.northPanelWidth, NorthPanelController.northPanelHeight));

        northPanel.add(CompanyName.getTitlePanel(), BorderLayout.WEST);
        northPanel.add(SearchPanel.getSearchPanel());

        mainPanel.add(northPanel, BorderLayout.NORTH);
    }
}
