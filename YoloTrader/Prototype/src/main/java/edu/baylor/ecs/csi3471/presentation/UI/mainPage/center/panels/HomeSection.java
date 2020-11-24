package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels;

import javax.swing.*;

public class HomeSection {

    public static JPanel homeMainPanel;

    public static JPanel getHomeMainPanel() {
        return homeMainPanel;
    }

    public static void setHomeMainPanel() {
        HomeSection.homeMainPanel = new JPanel();

        homeMainPanel.add(new JLabel("<html><B>HELLO</B></html>"));
    }
}
