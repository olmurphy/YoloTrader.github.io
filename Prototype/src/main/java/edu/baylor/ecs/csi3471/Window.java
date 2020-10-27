package edu.baylor.ecs.csi3471;

import javax.swing.*;
import java.awt.*;

public class Window {

    public static void CreateWindow() {
        (new Window()).signIn();
    }

    public void signIn() {
        JFrame signInFrame = new JFrame();

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        // creating panels
        JPanel signInPanel = new JPanel(new GridLayout(4,1));
        JPanel titlePanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        // sign in button
        JButton signInButton = new JButton("Login");
        JButton createAccButton = new JButton("Create Account");
        JButton helpButton = new JButton("Need Help?");

        // App name title
        JLabel appName = new JLabel("YoloTrader");
        appName.setVerticalAlignment(JLabel.CENTER);
        appName.setHorizontalAlignment(JLabel.CENTER);

        // create username fields
        JLabel userLabel = new JLabel("Username: ");
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField userText = new JTextField();

        // create password fields
        JLabel passLabel = new JLabel("Password: " );
        passLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField passText = new JTextField();

        // help field



        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        signInPanel.add(userLabel);
        signInPanel.add(userText);
        signInPanel.add(passLabel);
        signInPanel.add(passText);
        mainPanel.add(signInPanel);

        // add button fields to pane
        buttonPanel.add(signInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);



        signInFrame.add(mainPanel);
        signInFrame.pack();
        signInFrame.setVisible(true);
        signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
