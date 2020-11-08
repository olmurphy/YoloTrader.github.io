package edu.baylor.ecs.csi3471.UI.west.subpanels;

import edu.baylor.ecs.csi3471.UI.west.WestPanelController;

import javax.swing.*;

public class Help {

    public static JPanel helpPanel;
    public static String helpButtonString = "HELP";

    public static JPanel getHelpPanel() {
        helpPanel = WestPanelController.getEachWestSubPanel();

        JLabel helpLabel = new JLabel(helpButtonString, JLabel.CENTER);
        helpLabel.setFont(WestPanelController.panelLabelFonts);
        helpPanel.add(helpLabel);
        helpPanel.setBackground(WestPanelController.westPanelColor);
        helpPanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(helpPanel));
        helpPanel.addMouseListener(WestPanelController.getHelpPanelAction());

        return helpPanel;
    }

}
