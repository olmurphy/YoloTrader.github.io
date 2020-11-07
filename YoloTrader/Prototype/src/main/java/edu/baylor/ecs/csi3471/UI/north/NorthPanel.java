package edu.baylor.ecs.csi3471.UI.north;

import edu.baylor.ecs.csi3471.UI.north.title.CompanyName;

import javax.swing.*;
import java.awt.*;

public class NorthPanel {

    public static JPanel northPanel;


    public static void createNorthPanel(JPanel mainPanel) {
        northPanel = new JPanel(new BorderLayout());

        northPanel.setPreferredSize(new Dimension(NorthPanelUtility.northPanelWidth, NorthPanelUtility.northPanelHeight));


        northPanel.add(CompanyName.getTitlePanel(), BorderLayout.WEST);

        mainPanel.add(northPanel, BorderLayout.NORTH);
    }
}
