package edu.baylor.ecs.csi3471.UI.west.profile;

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
        profilePanel.addMouseListener(getProfilePanelAction());

        return profilePanel;
    }

    public static MouseAdapter getProfilePanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                // FIXME: add cool effects
            }
        };
    }
}
