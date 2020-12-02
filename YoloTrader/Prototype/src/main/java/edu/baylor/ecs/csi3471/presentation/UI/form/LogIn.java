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

    /** return the frame of the log-ing page */
    public static JFrame getFrame() { return frame; }

    /** @return label storing the company name that is used on the log-in page and the create account forms */
    public static JLabel getCompanyLabel() { return new JLabel(companyString, JLabel.CENTER); }

    /** @return email label associated with its email field */
    public static JLabel getEmailLabel() { return new JLabel(emailString); }

    /**
     * sets the email field to receive user input for their email
     * @param emailField field to be set to
     */
    public static void setEmailField(JTextField emailField) { LogIn.emailField = emailField; }

    /** @return email field to add to log-in page of UI */
    public static JTextField getEmailField() { return emailField; }

    /** @return password label associated with its respective field  */
    public static JLabel getPassLabel() { return new JLabel(passString); }

    /**
     * sets the password field to listen for user input
     * @param passwordField field to be set to
     */
    public static void setPasswordField(JPasswordField passwordField) { LogIn.passwordField = passwordField; }

    /** @return password field to add to log-in page of UI */
    public static JPasswordField getPasswordField() { return passwordField; }

    /** returns the log-in button to add to UI of log-in page */
    public static JButton getLogInButton() { return loginButton; }

    /** @return create account button to add to log-in page UI */
    public static JButton getCreateAccountButton() { return createAccountButton; }

    /** sets the create account button which switches to create account form if it is pressed inside the log-ing form */
    public static void setCreateAccountButton() { createAccountButton.addActionListener(FormController.getGeneralFormAction(FormController.login)); }

    /** @return button for the help to add to UI */
    public static JButton getHelpButton() { return helpButton; }

    /** sets the help button and adds the listener and well as the UI listener */
    public static void setHelpButton() { helpButton.addActionListener(FormController.getGeneralFormAction(FormController.login)); }

    /** method is called at the beginning of the application to start on the log-in form page */
    public static void startFrame() {
        frame = new JFrame("Log-In");

        frame.add(getLogInPanel());
        frame.getRootPane().setDefaultButton(getLogInButton());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /** @return JPanel that stores the log-in form on */
    public static JPanel getLogInPanel() {
        logInPanel = new JPanel();
        logInPanel.setLayout(new BoxLayout(logInPanel, BoxLayout.Y_AXIS));
        logInPanel.setBackground(FormController.formColor);

        logInPanel.add(getCompanyLabel());
        logInPanel.add(getFieldPanel());
        logInPanel.add(getButtonPanel());

        return logInPanel;
    }

    /** @return JPanel storing the email and password fields */
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

    /** @return  JPanel storing the buttons on the log-in form */
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

    /** sets the login button and adds the log-in action */
    public static void setLoginButton() {
        // action will switch to crete account
        LogIn.loginButton.addActionListener(FormController.getGeneralFormAction(FormController.login));

        // action will generate credential checking if log-in is pressed
        LogIn.loginButton.addActionListener(FormController.getLogInAction());
    }

    /** sets all buttons when the app starts */
    public static void setAllButtons() {
        setLoginButton();
        setHelpButton();
        setCreateAccountButton();
    }

    /** initialize all buttons when app starts */
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

    /** creates warning dialog notifying user that fields are empty */
    public static void getEmptyFieldWarning() {
        JOptionPane.showMessageDialog(null, "Some fields have not been filled in",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /** lets user know the credentials input are no match in database */
    public static void getInvalidCredentialsWarning() {
        JOptionPane.showMessageDialog(null, "Invalid Credentials",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
