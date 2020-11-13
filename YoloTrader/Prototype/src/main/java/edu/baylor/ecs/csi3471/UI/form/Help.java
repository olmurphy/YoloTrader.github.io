package edu.baylor.ecs.csi3471.UI.form;

import javax.swing.*;
import java.awt.*;

public class Help {


    public static void createHelp() {
        JFrame helpFrame = new JFrame("Help");

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        // creating panels
        JPanel infoPanel = new JPanel(new GridLayout(1, 1));
        JPanel titlePanel = new JPanel(new BorderLayout());

        JLabel emailHelpLabel = new JLabel("volatiles.stocks@gmail.com");
        emailHelpLabel.setHorizontalAlignment(JLabel.LEFT);

        // App name title
        JLabel appName = new JLabel(FormController.title);
        appName.setVerticalAlignment(JLabel.CENTER);
        appName.setHorizontalAlignment(JLabel.CENTER);

        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add help contact to pane
        infoPanel.add(emailHelpLabel);
        mainPanel.add(infoPanel);


        // add mainPanel to frame and set frame values
        helpFrame.add(mainPanel);
        helpFrame.pack();
        helpFrame.setVisible(true);
        helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
