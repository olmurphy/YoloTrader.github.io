package edu.baylor.ecs.csi3471.presentation.UI.form;

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

    public static JFrame frame;

    public static JLabel getFirstLabel() { return new JLabel(firstString); }

    public static void setFirstField(JTextField firstField) { CreateAccount.firstField = firstField; }

    public static JTextField getFirstField() { return firstField; }

    public static JLabel getLastLabel() { return new JLabel(lastString); }

    public static void setLastField(JTextField lastField) { CreateAccount.lastField = lastField; }

    public static JTextField getLastField() { return lastField; }

    public static JLabel getUserLabel() { return new JLabel(userString); }

    public static void setUserField(JTextField userField) { CreateAccount.userField = userField; }

    public static JTextField getUserField() { return userField; }

    public static JLabel getPasswordAgainLabel() { return new JLabel(passwordAgainStr); }

    public static void setRe_passwordField(JPasswordField re_passwordField) {
        CreateAccount.re_passwordField = re_passwordField;
    }

    public static JPasswordField getRe_passwordField() { return re_passwordField; }

    public static JFrame getFrame() { return frame; }

    public static void getPassNotMatchWarning() {
        JOptionPane.showMessageDialog(null, "Passwords do NOT match",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void startCreateAccount() {

        frame = new JFrame("Create Account");

        frame.add(CreateAccount.getCreateAccPanel());
        frame.getRootPane().setDefaultButton(getCreateAccountButton());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

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

    public static JButton getLogInButton() {
        LogIn.getLogInButton().addActionListener(FormController.getGeneralFormAction(FormController.createAcc));
        return LogIn.getLogInButton();
    }

    public static JButton getCreateAccountButton() {
        LogIn.getCreateAccountButton().addActionListener(FormController.getGeneralFormAction(FormController.createAcc));

        LogIn.getCreateAccountButton().addActionListener(FormController.getCreateAccountAction());

        return LogIn.getCreateAccountButton();
    }
}
