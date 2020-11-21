package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class Name {

    private static String name;
    public  static JPanel welcomePanel;

    public static JPanel getWelcomePanel() {
        welcomePanel = new JPanel(new GridLayout(1, 1));

        welcomePanel.add(getLabel(name));
        welcomePanel.setBackground(NorthPanelController.northPanelColor);

        return welcomePanel;
    }

    public static JLabel getLabel(String name) {
        Name.name = name;

        JLabel welcomeLabel = new JLabel("Welcome, " + Name.name + "!", JLabel.RIGHT);
        welcomeLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
        welcomeLabel.setBackground(NorthPanelController.northPanelColor);

        return welcomeLabel;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Name.name = name;
    }

}
