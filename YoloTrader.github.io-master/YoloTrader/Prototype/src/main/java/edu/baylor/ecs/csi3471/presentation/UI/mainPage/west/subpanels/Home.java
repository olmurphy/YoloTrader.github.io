package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class Home {

    public static String homePanelLabel = "<html><span style=\"font-family:Arial;font-size:" +
            WestPanelController.size + "px;\"><B>HOME</B>";
    public static JPanel homePanel;

    public static JPanel getHomePanel() {
        return homePanel;
    }

    public static void setHomePanel() {
        homePanel = WestPanelController.getEachWestSubPanel();

        JLabel homeLabel = new JLabel(homePanelLabel, JLabel.CENTER);
        homePanel.add(homeLabel);
        homePanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(homePanel, homePanelLabel));
        homePanel.addMouseListener(WestPanelController.getHomePanelAction(homePanel, homePanelLabel));

        homePanel.setBackground(WestPanelController.westPanelColor);
    }
}
