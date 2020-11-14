package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class Home {

    public static String homeButtonString = "HOME";
    public static JPanel homePanel;

    public static JPanel getHomePanel() {
        homePanel = WestPanelController.getEachWestSubPanel();

        JLabel homeLabel = new JLabel(homeButtonString, JLabel.CENTER);
        homeLabel.setFont(WestPanelController.panelLabelFonts);
        homePanel.add(homeLabel);
        homePanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(homePanel));
        homePanel.addMouseListener(WestPanelController.getHomePanelAction());


        homePanel.setBackground(WestPanelController.westPanelColor);

        return homePanel;
    }









}
