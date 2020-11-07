package edu.baylor.ecs.csi3471.UI.west.subpanels;

import edu.baylor.ecs.csi3471.UI.west.WestPanelUtility;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profile {

    public static String profilePanelLabel = "PROFILE";
    public static JPanel profilePanel;

    public static JPanel getProfilePanel() {
        profilePanel = WestPanelUtility.getEachWestSubPanel();

        JLabel profileLabel = new JLabel(profilePanelLabel, JLabel.CENTER);
        profileLabel.setFont(WestPanelUtility.panelLabelFonts);
        profilePanel.add(profileLabel);
        profilePanel.setBackground(WestPanelUtility.westPanelColor);
        profilePanel.addMouseListener(WestPanelUtility.getGeneralWestPanelActions(profilePanel));
        profilePanel.addMouseListener(WestPanelUtility.getProfilePanelAction());

        return profilePanel;
    }


}
