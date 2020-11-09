package edu.baylor.ecs.csi3471.UI.form;


import javax.swing.*;
import java.awt.*;

public class LogIn {


    public static void logIn() {
        JFrame loginFrame = new JFrame("Log-In");

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        // creating panels
        JPanel logInPanel = new JPanel(new GridLayout(4,1));
        JPanel titlePanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        // sign in button
        JButton logInButton = new JButton(FormController.login);
        JButton createAccButton = new JButton(FormController.createAcc);
        JButton helpButton = new JButton(FormController.help);

        logInButton.addActionListener(FormController.getGeneralFormAction(FormController.login, loginFrame));
        createAccButton.addActionListener(FormController.getGeneralFormAction(FormController.login, loginFrame));
        helpButton.addActionListener(FormController.getGeneralFormAction(FormController.login, loginFrame));

        // App name title
        JLabel appName = new JLabel(FormController.title);
        appName.setVerticalAlignment(JLabel.CENTER);
        appName.setHorizontalAlignment(JLabel.CENTER);

        // create username fields
        JLabel userLabel = new JLabel(FormController.usernameStr);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField userText = new JTextField();

        // create password fields
        JPasswordField passwordField = new JPasswordField();
        JLabel passLabel = new JLabel(FormController.usernameStr);
        passLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding color to buttons
        logInButton.setBackground(Color.CYAN);
        createAccButton.setBackground(Color.CYAN);
        helpButton.setBackground(Color.CYAN);
        logInButton.setOpaque(true);
        createAccButton.setOpaque(true);
        helpButton.setOpaque(true);


        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        logInPanel.add(userLabel);
        logInPanel.add(userText);
        logInPanel.add(passLabel);
        logInPanel.add(passwordField);
        mainPanel.add(logInPanel);

        // add button fields to pane
        buttonPanel.add(logInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);

        // add mainPanel to frame and set frame values
        loginFrame.add(mainPanel);
        loginFrame.setVisible(true);
        loginFrame.setSize(FormController.width, FormController.height);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
