package edu.baylor.ecs.csi3471.presentation.ui.form;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class CreateAccount {

    public static String userString = FormController.leftLabelSide + "Username" + FormController.rightLabelSide;
    public static String firstString = FormController.leftLabelSide + "First" + FormController.rightLabelSide;
    public static String lastString = FormController.leftLabelSide + "Last" + FormController.rightLabelSide;
    public static String passwordAgainStr = FormController.leftLabelSide + "Re-Password" + FormController.rightLabelSide;

    public static JPanel createAccPanel;
    public static JPanel firstLastPanel;
    public static JPanel fieldPanel;
    public static JPanel buttonPanel;

    public static JTextField firstField;
    public static JTextField lastField;
    public static JTextField userField;
    public static JPasswordField re_passwordField;

    /** frame stores create account field */
    public static JFrame frame;

    /** @return first label associated with the first field */
    public static JLabel getFirstLabel() { return new JLabel(firstString); }

    /**
     * sets the first field to receive user input
     * @param firstField field to be set to
     */
    public static void setFirstField(JTextField firstField) { CreateAccount.firstField = firstField; }

    /** @return first field to receive user input indicating user's first name */
    public static JTextField getFirstField() { return firstField; }

    /** @return last label associated with its field */
    public static JLabel getLastLabel() { return new JLabel(lastString); }

    /**
     * sets the last field to receive user input
     * @param lastField field to be set to
     */
    public static void setLastField(JTextField lastField) { CreateAccount.lastField = lastField; }

    /** @return last field receiving input from user indicating their last name */
    public static JTextField getLastField() { return lastField; }

    /** @return user Label associated with its field */
    public static JLabel getUserLabel() { return new JLabel(userString); }

    /**
     * sets the user field that will recieve input from user
     * @param userField user field to be set it
     */
    public static void setUserField(JTextField userField) { CreateAccount.userField = userField; }

    /** username field to get user input */
    public static JTextField getUserField() { return userField; }

    /** @return password again label */
    public static JLabel getPasswordAgainLabel() { return new JLabel(passwordAgainStr); }

    /**
     * sets the enter password again field
     * @param re_passwordField password field to be set to
     */
    public static void setRe_passwordField(JPasswordField re_passwordField) { CreateAccount.re_passwordField = re_passwordField; }

    /** @return password field for verifying password again */
    public static JPasswordField getRe_passwordField() { return re_passwordField; }

    /** @return JFrame that has the create account form on it */
    public static JFrame getFrame() { return frame; }

    /** dialog that tells user that the 2 pass fields do not match */
    public static void getPassNotMatchWarning() {
        JOptionPane.showMessageDialog(null, "Passwords do NOT match",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /** starts the main frame that has the create account JPanel on it */
    public static void startCreateAccount() {
        frame = new JFrame("Create Account");

        frame.add(CreateAccount.getCreateAccPanel());
        frame.getRootPane().setDefaultButton(getCreateAccountButton());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * main create account panel the holds everything involving the create account form
     * @return JPanel that has the create account form
     */
    public static JPanel getCreateAccPanel() {
        createAccPanel = new JPanel();
        createAccPanel.setLayout(new BoxLayout(createAccPanel, BoxLayout.Y_AXIS));
        createAccPanel.setBackground(FormController.formColor);

        // adding company title to create account form
        createAccPanel.add(LogIn.getCompanyLabel());

        // adding fields to panel
        createAccPanel.add(getFieldPanel());

        // adding all buttons to panel
        createAccPanel.add(getButtonPanel());

        return createAccPanel;
    }

    /**
     * stores all the fields associated with creating an account
     * @return JPanel that holds all the fields
     */
    public static JPanel getFieldPanel() {
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(9, 1));
        fieldPanel.setBackground(FormController.formColor);

        // adding first & last name fields
        fieldPanel.add(getFirstLastPanel());

        // adding username field
        setUserField(new JTextField());
        fieldPanel.add(getUserLabel());
        fieldPanel.add(getUserField());

        // adding email field
        LogIn.setEmailField(new JTextField());
        fieldPanel.add(LogIn.getEmailLabel());
        fieldPanel.add(LogIn.getEmailField());

        // adding password and re-password field
        LogIn.setPasswordField(new JPasswordField());
        setRe_passwordField(new JPasswordField());
        fieldPanel.add(LogIn.getPassLabel());
        fieldPanel.add(LogIn.getPasswordField());
        fieldPanel.add(getPasswordAgainLabel());
        fieldPanel.add(getRe_passwordField());

        return fieldPanel;
    }

    /**
     * stores the first and last labels and fields for the create account form
     * @return JPanel holding these fields
     */
    public static JPanel getFirstLastPanel() {
        firstLastPanel = new JPanel();
        firstLastPanel.setLayout(new GridLayout(2, 2));
        firstLastPanel.setBackground(FormController.formColor);

        // adding name labels
        firstLastPanel.add(getFirstLabel());
        firstLastPanel.add(getLastLabel());

        // adding name fields
        setFirstField(new JTextField());
        setLastField(new JTextField());
        firstLastPanel.add(getFirstField());
        firstLastPanel.add(getLastField());

        return firstLastPanel;
    }

    /**
     * button panel stores the log-in and create account button
     * @return JPanel with the buttons on it
     */
    public static JPanel getButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.setBackground(FormController.formColor);

        // need to re-initialize for createAccount specific
        LogIn.initializeButtons();
        buttonPanel.add(getLogInButton());
        LogIn.getHelpButton().addActionListener(FormController.getGeneralFormAction(FormController.createAcc));
        buttonPanel.add(LogIn.getHelpButton());
        buttonPanel.add(getCreateAccountButton());

        return buttonPanel;
    }

    /** @return returns the log-in button for the create account form */
    public static JButton getLogInButton() {
        LogIn.getLogInButton().addActionListener(FormController.getGeneralFormAction(FormController.createAcc));
        return LogIn.getLogInButton();
    }

    /** @return returns the button for create account form */
    public static JButton getCreateAccountButton() {
        LogIn.getCreateAccountButton().addActionListener(FormController.getGeneralFormAction(FormController.createAcc));

        LogIn.getCreateAccountButton().addActionListener(FormController.getCreateAccountAction());

        return LogIn.getCreateAccountButton();
    }
}
