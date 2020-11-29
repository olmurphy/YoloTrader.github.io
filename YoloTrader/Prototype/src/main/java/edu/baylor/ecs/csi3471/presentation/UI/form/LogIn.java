package edu.baylor.ecs.csi3471.presentation.UI.form;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class LogIn {

    public static JPanel logInPanel;
    public static JPanel fieldPanel;
    public static JPanel buttonPanel;

    public static JButton loginButton;
    public static JButton createAccountButton;
    public static JButton helpButton;

    public static String emailString = FormController.leftLabelSide + "Email" + FormController.rightLabelSide;
    public static String passString = FormController.leftLabelSide + "Password" + FormController.rightLabelSide;

    public static JTextField emailField;
    public static JPasswordField passwordField;

    public static JFrame frame;

    public static String companyString = "<html><span style=\"font-family:Arial;font-size:20px;color:white;\"><B>" + FormController.title + "</B>";

    public static JFrame getFrame() { return frame; }

    public static JLabel getCompanyLabel() { return new JLabel(companyString, JLabel.CENTER); }

    public static JLabel getEmailLabel() { return new JLabel(emailString); }

    public static void setEmailField(JTextField emailField) { LogIn.emailField = emailField; }

    public static JTextField getEmailField() { return emailField; }

    public static JLabel getPassLabel() { return new JLabel(passString); }

    public static void setPasswordField(JPasswordField passwordField) { LogIn.passwordField = passwordField; }

    public static JPasswordField getPasswordField() { return passwordField; }

    public static JButton getLogInButton() { return loginButton; }

    public static JButton getCreateAccountButton() { return createAccountButton; }

    public static void setCreateAccountButton() { createAccountButton.addActionListener(FormController.getGeneralFormAction(FormController.login)); }

    public static JButton getHelpButton() { return helpButton; }

    public static void setHelpButton() { helpButton.addActionListener(FormController.getGeneralFormAction(FormController.login)); }

    public static void startFrame() {
        frame = new JFrame("Log-In");

        frame.add(getLogInPanel());
        frame.getRootPane().setDefaultButton(getLogInButton());
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

    public static JPanel getFieldPanel() {
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        fieldPanel.setBackground(FormController.formColor);

        // adding email field
        setEmailField(new JTextField());
        fieldPanel.add(getEmailLabel());
        fieldPanel.add(getEmailField());

        // adding password field
        setPasswordField(new JPasswordField());
        fieldPanel.add(getPassLabel());
        fieldPanel.add(getPasswordField());

        return fieldPanel;
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

    public static void setLoginButton() {
        LogIn.loginButton
                .addActionListener(FormController.getGeneralFormAction(FormController.login));

        LogIn.loginButton
                .addActionListener(FormController.getLogInAction());
    }

    public static void setAllButtons() {
        setLoginButton();
        setHelpButton();
        setCreateAccountButton();
    }

    public static void initializeButtons() {

        FormController.login = FormController.leftButtonSide +  FormController.login + FormController.rightButtonSide;
        loginButton = new JButton(FormController.login);
        loginButton.setHorizontalAlignment(JButton.CENTER);
        loginButton.setVerticalAlignment(JButton.CENTER);
        loginButton.addMouseListener(CenterPanelController.getGeneralButtonAction(loginButton));
        loginButton.setBackground(FormController.formColor);
        loginButton.setBorder(BorderFactory.createEmptyBorder());

        FormController.createAcc = FormController.leftButtonSide +  FormController.createAcc + FormController.rightButtonSide;
        createAccountButton = new JButton(FormController.createAcc);
        createAccountButton.setHorizontalAlignment(JButton.CENTER);
        createAccountButton.setVerticalAlignment(JButton.CENTER);
        createAccountButton.addMouseListener(CenterPanelController.getGeneralButtonAction(createAccountButton));
        createAccountButton.setBackground(FormController.formColor);
        createAccountButton.setBorder(BorderFactory.createEmptyBorder());

        FormController.help = FormController.leftButtonSide +  FormController.help + FormController.rightButtonSide;
        helpButton = new JButton(FormController.help);
        helpButton.setHorizontalAlignment(JButton.CENTER);
        helpButton.setVerticalAlignment(JButton.CENTER);
        helpButton.addMouseListener(CenterPanelController.getGeneralButtonAction(helpButton));
        helpButton.setBackground(FormController.formColor);
        helpButton.setBorder(BorderFactory.createEmptyBorder());
    }

    public static void getEmptyFieldWarning() {
        JOptionPane.showMessageDialog(null, "Some fields have not been filled in",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void getInvalidCredentialsWarning() {
        JOptionPane.showMessageDialog(null, "Invalid Credentials",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
