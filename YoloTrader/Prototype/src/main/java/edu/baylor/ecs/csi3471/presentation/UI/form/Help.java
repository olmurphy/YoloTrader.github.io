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
        helpDialog.setLocationRelativeTo(null); // centers dialog in middle of screen
        helpDialog.pack();
        helpDialog.setVisible(true);
        /*
        JDialog dialog = new JDialog();
        dialog.add(getSearchPanel());

        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLocationRelativeTo(null);     // centers the frame in the middle of the screen
                                                // regardless of the dual monitor setup
        dialog.pack();                          // optimal if application is running on different computers
        dialog.setVisible(true);
         */

    }

    public static JButton getForgotPassButton() {
        return forgotPassButton;
    }

    public static void setForgotPassButton(JButton forgotPassButton) {

        Help.forgotPassButton = forgotPassButton;

        // FIXME: add the button listener to this
        Help.forgotPassButton.addActionListener(null);
    }
}
