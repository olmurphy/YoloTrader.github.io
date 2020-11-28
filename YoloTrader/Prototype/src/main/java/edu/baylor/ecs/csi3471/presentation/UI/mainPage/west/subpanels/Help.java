package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;

import java.awt.Color;

import javax.swing.*;

public class Help {

    public static JPanel helpPanel;
    public static String helpPanelLabel = "<html><span style=\"font-family:Futura;font-size:" +
            WestPanelController.size + "px;color:white;\"><B>HELP</B>";

    public static JPanel getHelpPanel() {
        return helpPanel;
    }

    public static void setHelpPanel() {
        helpPanel = WestPanelController.getEachWestSubPanel();

        JLabel helpLabel = new JLabel(helpPanelLabel, JLabel.CENTER);
        
        helpPanel.add(helpLabel);
        helpPanel.setBackground(WestPanelController.westPanelColor);
        helpPanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(helpPanel, helpPanelLabel));
        helpPanel.addMouseListener(WestPanelController.getHelpPanelAction(helpPanel, helpPanelLabel));
    }
}
