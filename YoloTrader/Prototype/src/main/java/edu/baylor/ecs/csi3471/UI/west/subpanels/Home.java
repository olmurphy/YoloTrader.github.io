package edu.baylor.ecs.csi3471.UI.west.subpanels;

import edu.baylor.ecs.csi3471.UI.west.WestPanelUtility;

import javax.swing.*;

public class Home {

    public static String homeButtonString = "HOME";
    public static JPanel homePanel;

    public static JPanel getHomePanel() {
        homePanel = WestPanelUtility.getEachWestSubPanel();

        JLabel homeLabel = new JLabel(homeButtonString, JLabel.CENTER);
        homeLabel.setFont(WestPanelUtility.panelLabelFonts);
        homePanel.add(homeLabel);
        homePanel.addMouseListener(WestPanelUtility.getGeneralWestPanelActions(homePanel));
        homePanel.addMouseListener(WestPanelUtility.getHomePanelAction());


        homePanel.setBackground(WestPanelUtility.westPanelColor);

        return homePanel;
    }









}
