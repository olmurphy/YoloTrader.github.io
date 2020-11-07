package edu.baylor.ecs.csi3471.UI.west.profile;

import edu.baylor.ecs.csi3471.UI.west.home.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Profile {

    public static String profilePanelLabel = "PROFILE";
    public static JPanel profilePanel;

    public static JPanel getProfilePanel() {
        profilePanel = new JPanel(new GridLayout(1,1));

        profilePanel.add(new JLabel(profilePanelLabel, JLabel.CENTER));
        profilePanel.setBackground(Home.westPanelColor);

        return profilePanel;
    }

    public static MouseAdapter getProfilePanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        };
    }
}
