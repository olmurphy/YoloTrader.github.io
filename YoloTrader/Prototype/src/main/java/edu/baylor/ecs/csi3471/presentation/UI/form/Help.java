package edu.baylor.ecs.csi3471.presentation.UI.form;

import javax.swing.*;
import java.awt.*;

/**
 * this class is a UI class that displays the company email to contact as well
 * as the forgot password functionality
 * @author owenmurphy
 */
public class Help {
    
    private static JButton forgotPassButton;

    public static void createHelp() {
        JDialog helpDialog = new JDialog();
        helpDialog.setTitle("Help");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // creating help label
        JLabel emailHelpLabel = new JLabel(Email.companyEmail);
        emailHelpLabel.setHorizontalAlignment(JLabel.LEFT);

        // adding help label to main help panel
        mainPanel.add(emailHelpLabel);

        // setting and adding forgot password
        setForgotPassButton(new JButton("Forgot Password"));
        mainPanel.add(getForgotPassButton());

        // add mainPanel to dialog
        helpDialog.add(mainPanel);

        helpDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // opens dialog in separate window
        helpDialog.setLocationRelativeTo(null); // centers dialog in middle of screen

        helpDialog.pack();
        helpDialog.setVisible(true);

    }

    public static JButton getForgotPassButton() {
        return forgotPassButton;
    }

    public static void setForgotPassButton(JButton forgotPassButton) {
        Help.forgotPassButton = forgotPassButton;

        // adding logic to the button
        Help.forgotPassButton.addActionListener(FormController.getForgotPasswordButtonListener());
    }
}
