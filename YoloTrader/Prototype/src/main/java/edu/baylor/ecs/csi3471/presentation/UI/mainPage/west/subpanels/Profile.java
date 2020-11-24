package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class Profile {

    public static String profilePanelLabel = "<html><span style=\"font-family:Arial;font-size:" +
            WestPanelController.size + "px;\"><B>PROFILE</B>";
    public static JPanel profilePanel;

    public static JPanel getProfilePanel() {
        return profilePanel;
    }

    public static void setProfilePanel() {
        profilePanel = WestPanelController.getEachWestSubPanel();

        JLabel profileLabel = new JLabel(profilePanelLabel, JLabel.CENTER);

        profilePanel.add(profileLabel);
        profilePanel.setBackground(WestPanelController.westPanelColor);
        profilePanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(profilePanel, profilePanelLabel));
        profilePanel.addMouseListener(WestPanelController.getProfilePanelAction(profilePanel, profilePanelLabel));

    }
}
