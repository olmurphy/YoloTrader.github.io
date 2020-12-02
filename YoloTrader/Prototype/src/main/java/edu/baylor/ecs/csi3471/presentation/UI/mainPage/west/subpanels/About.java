package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class About {

    public static String aboutPanelLabel = "<html><span style=\"font-family:Futura;font-size:" + WestPanelController.size + "px;color:white\"><B>ABOUT</B>";
    public static JPanel aboutPanel;

    public static JPanel getAboutPanel() { return aboutPanel; }

    public static void setAboutPanel() {
        aboutPanel = WestPanelController.getEachWestSubPanel();

        JLabel aboutLabel = new JLabel(aboutPanelLabel, JLabel.CENTER);
        aboutPanel.add(aboutLabel);
        aboutPanel.setBackground(WestPanelController.westPanelColor);
        aboutPanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(aboutPanel, aboutPanelLabel));
        aboutPanel.addMouseListener(WestPanelController.getAboutPanelAction(aboutPanel, aboutPanelLabel));
    }
}
