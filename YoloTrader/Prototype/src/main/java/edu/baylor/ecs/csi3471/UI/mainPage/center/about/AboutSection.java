package edu.baylor.ecs.csi3471.UI.mainPage.center.about;

import edu.baylor.ecs.csi3471.UI.mainPage.center.CenterPanelController;

import javax.swing.*;

public class AboutSection {

    public static JPanel mainAboutPanel;
    public static JPanel aboutPanel;
    public static JPanel developersPanel;

    public static String aboutString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>ABOUT</B>";
    public static String developerString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>DEVELOPERS</B>";

    public static JPanel getMainAboutPanel() {
        mainAboutPanel = new JPanel();
        mainAboutPanel.setLayout(new BoxLayout(mainAboutPanel, BoxLayout.Y_AXIS));
        mainAboutPanel.setBackground(CenterPanelController.centerPanelColor);

        mainAboutPanel.add(getAboutPanel());
        mainAboutPanel.add(getDevelopersPanel());

        return mainAboutPanel;
    }

    public static JPanel getAboutPanel() {
        aboutPanel = new JPanel();
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        aboutPanel.setBackground(CenterPanelController.centerPanelColor);

        aboutPanel.add(getAboutLabel());

        return aboutPanel;
    }

    public static JPanel getDevelopersPanel() {
        developersPanel = new JPanel();
        developersPanel.setLayout(new BoxLayout(developersPanel, BoxLayout.Y_AXIS));
        developersPanel.setBackground(CenterPanelController.centerPanelColor);

        developersPanel.add(getDeveloperLabel());

        return developersPanel;
    }

    public static JLabel getAboutLabel() {
        return new JLabel(aboutString);
    }

    public static JLabel getDeveloperLabel() {
        return new JLabel(developerString);
    }
}
