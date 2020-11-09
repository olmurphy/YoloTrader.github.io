package edu.baylor.ecs.csi3471.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class Profile {

    public static String profilePanelLabel = "PROFILE";
    public static JPanel profilePanel;

    public static JPanel getProfilePanel() {
        profilePanel = WestPanelController.getEachWestSubPanel();

        JLabel profileLabel = new JLabel(profilePanelLabel, JLabel.CENTER);
        profileLabel.setFont(WestPanelController.panelLabelFonts);
        profilePanel.add(profileLabel);
        profilePanel.setBackground(WestPanelController.westPanelColor);
        profilePanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(profilePanel));
        profilePanel.addMouseListener(WestPanelController.getProfilePanelAction());

        return profilePanel;
    }


}
