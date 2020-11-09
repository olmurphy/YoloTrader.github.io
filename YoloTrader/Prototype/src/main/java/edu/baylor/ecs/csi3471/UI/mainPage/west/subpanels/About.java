package edu.baylor.ecs.csi3471.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class About {

    public static String aboutButtonString = "ABOUT";
    public static JPanel aboutPanel;


    public static JPanel getAboutPanel() {
        aboutPanel = WestPanelController.getEachWestSubPanel();

        JLabel aboutLabel = new JLabel(aboutButtonString, JLabel.CENTER);
        aboutLabel.setFont(WestPanelController.panelLabelFonts);
        aboutPanel.add(aboutLabel);
        aboutPanel.setBackground(WestPanelController.westPanelColor);
        aboutPanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(aboutPanel));
        aboutPanel.addMouseListener(WestPanelController.getAboutPanelAction());

        return aboutPanel;
    }



}
