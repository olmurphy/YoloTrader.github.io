package edu.baylor.ecs.csi3471.presentation.UI.form;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class Help {

    // FIXME: still working on it.
    
    private static JButton forgotPassButton;

    public static void createHelp() {
        JFrame helpFrame = new JFrame("Help");

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

        // add mainPanel to frame and set frame values
        helpFrame.add(mainPanel);
        helpFrame.pack();
        helpFrame.setVisible(true);
        helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
