package edu.baylor.ecs.csi3471.UI.form;

import javax.swing.*;
import java.awt.*;

public class CreateAccount {

    public static String passwordAgainStr = "Re-enter Password: ";

    public static void createAccount() {
        JFrame createAccountFrame = new JFrame("Create Account");

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        // creating panels
        JPanel signInPanel = new JPanel(new GridLayout(6,1));
        JPanel titlePanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        // sign in button
        JButton signInButton = new JButton(FormController.login);
        JButton createAccButton = new JButton(FormController.createAcc);
        JButton helpButton = new JButton(FormController.help);

        // adding the general buttons to the Form pages (i.e. switching between forms) :)
        signInButton.addActionListener(FormController.getGeneralFormAction(FormController.createAcc, createAccountFrame));
        createAccButton.addActionListener(FormController.getGeneralFormAction(FormController.createAcc, createAccountFrame));
        helpButton.addActionListener(FormController.getGeneralFormAction(FormController.createAcc, createAccountFrame));

        // App name title
        JLabel appName = new JLabel(FormController.title);
        appName.setVerticalAlignment(JLabel.CENTER);
        appName.setHorizontalAlignment(JLabel.CENTER);

        // create username fields
        JLabel userLabel = new JLabel(FormController.usernameStr);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField userText = new JTextField();

        // create password fields
        JLabel passLabel = new JLabel(FormController.passwordStr);
        JLabel passLabelConfirm = new JLabel(passwordAgainStr);
        passLabelConfirm.setHorizontalAlignment(JLabel.CENTER);
        passLabel.setHorizontalAlignment(JLabel.CENTER);
        JPasswordField passwordField = new JPasswordField();
        JPasswordField passwordFieldConfirm = new JPasswordField();

        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        signInPanel.add(userLabel);
        signInPanel.add(userText);
        signInPanel.add(passLabel);
        signInPanel.add(passwordField);
        signInPanel.add(passwordField);
        signInPanel.add(passwordFieldConfirm);
        mainPanel.add(signInPanel);

        // add button fields to pane
        buttonPanel.add(signInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);

        // add mainPanel to frame and set frame values
        createAccountFrame.add(mainPanel);
        createAccountFrame.setSize(FormController.width, FormController.height);
        createAccountFrame.setVisible(true);
        createAccountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
