package edu.baylor.ecs.csi3471.presentation.ui.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.ui.mainPage.west.WestPanelController;

import javax.swing.*;

public class Profile {

    public static String profilePanelLabel = "<html><span style=\"font-family:Futura;font-size:" + WestPanelController.size + "px;color:white;\"><B>PROFILE</B>";
    public static JPanel profilePanel;

    public static JPanel getProfilePanel() { return profilePanel; }

    public static void setProfilePanel() {
        profilePanel = WestPanelController.getEachWestSubPanel();

        JLabel profileLabel = new JLabel(profilePanelLabel, JLabel.CENTER);

        profilePanel.add(profileLabel);
        profilePanel.setBackground(WestPanelController.westPanelColor);
        profilePanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(profilePanel, profilePanelLabel));
        profilePanel.addMouseListener(WestPanelController.getProfilePanelAction(profilePanel, profilePanelLabel));
    }
}
