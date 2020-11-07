package edu.baylor.ecs.csi3471.UI.heading.search;

import javax.swing.*;
import java.awt.*;

public class Name {

    private static String name;
    public  static JPanel welcomePanel;

    public static JPanel getWelcomePanel(String name) {
        welcomePanel = new JPanel(new GridLayout(1, 1));

        welcomePanel.add(getLabel(name));

        return welcomePanel;
    }

    public static JLabel getLabel(String name) {
        Name.name = name;

        JLabel welcomeLabel = new JLabel("Welcome, " + Name.name + "!", JLabel.RIGHT);
        welcomeLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 15));

        return welcomeLabel;
    }


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Name.name = name;
    }

}
