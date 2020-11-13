package edu.baylor.ecs.csi3471.UI.form;

import javax.swing.*;
import java.awt.*;

public class LogIn {

    public static JPanel logInPanel;
    public static JPanel fieldPanel;
    public static JPanel buttonPanel;

    public static JButton loginButton;
    public static JButton createAccountButton;
    public static JButton helpButton;

    public static String emailString = "Email";
    public static String passString = "Password";

    public static JTextField emailField;
    public static JPasswordField passwordField;

    public static JFrame frame;

    public static String companyString = "<html><span style=\"" +
            "font-family:Arial;" +
            "font-size:20px;" +
            "\"><B>" + FormController.title +
            "</B>";


    public static void startWindowInLogIn() {
        frame = new JFrame("Log-In");

        frame.add(getLogInPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static JPanel getLogInPanel() {
        logInPanel = new JPanel();
        logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.Y_AXIS));
        logInPanel.setBackground(FormController.formColor);

        logInPanel.add(getCompanyLabel());
        logInPanel.add(getFieldPanel());
        logInPanel.add(getButtonPanel());

        return logInPanel;
    }

    public static JLabel getCompanyLabel() {
        return new JLabel(companyString, JLabel.CENTER);
    }

    public static JPanel getFieldPanel() {
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        fieldPanel.setBackground(FormController.formColor);

        fieldPanel.add(getEmailLabel());
        fieldPanel.add(getEmailField());
        fieldPanel.add(getPassLabel());
        fieldPanel.add(getPasswordField());

        return fieldPanel;
    }

    public static JLabel getEmailLabel() {
        return new JLabel(emailString);
    }

    public static JTextField getEmailField() {
        emailField = new JTextField();

        return emailField;
    }

    public static JLabel getPassLabel() {
        return new JLabel(passString);
    }

    public static JPasswordField getPasswordField() {
        passwordField = new JPasswordField();

        return passwordField;
    }

    public static JPanel getButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.setBackground(FormController.formColor);

        // need to restart all buttons to add specific functionality for log-in
        initializeButtons();

        // need to set all buttons specific for the log-in form
        setAllButtons();

        // adding the buttons
        buttonPanel.add(getLogInButton());
        buttonPanel.add(getHelpButton());
        buttonPanel.add(getCreateAccountButton());

        return buttonPanel;
    }

    public static JButton getLogInButton() {
        return loginButton;
    }

    public static void setLoginButton() {
        LogIn.loginButton
                .addActionListener(FormController.getGeneralFormAction(FormController.login));

        LogIn.loginButton
                .addActionListener(FormController.getLogInAction());
    }

    public static JButton getCreateAccountButton() {
        return createAccountButton;
    }

    public static void setCreateAccountButton() {
        createAccountButton
                .addActionListener(FormController.getGeneralFormAction(FormController.login));
    }

    public static JButton getHelpButton() {
        return helpButton;
    }

    public static void setHelpButton() {
        helpButton.addActionListener(FormController.getGeneralFormAction(FormController.login));
    }

    public static void setAllButtons() {
        setLoginButton();
        setHelpButton();
        setCreateAccountButton();
    }

    public static void initializeButtons() {
        loginButton = new JButton(FormController.login);
        loginButton.setHorizontalAlignment(JButton.CENTER);
        loginButton.setVerticalAlignment(JButton.CENTER);


        createAccountButton = new JButton(FormController.createAcc);
        createAccountButton.setHorizontalAlignment(JButton.CENTER);
        createAccountButton.setVerticalAlignment(JButton.CENTER);

        helpButton = new JButton(FormController.help);
        helpButton.setHorizontalAlignment(JButton.CENTER);
        helpButton.setVerticalAlignment(JButton.CENTER);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void getEmailWarning() {
        JOptionPane.showMessageDialog(null, "Invalid Email Format",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
