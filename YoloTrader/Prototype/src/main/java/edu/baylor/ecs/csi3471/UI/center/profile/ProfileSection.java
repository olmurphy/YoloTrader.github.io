package edu.baylor.ecs.csi3471.UI.center.profile;

import edu.baylor.ecs.csi3471.UI.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;

public class ProfileSection {

    /*
    FIXME: NEED TO FINISH DESIGNING THE PROFILE PANEL, UNFINISHED
     */


    public static JPanel profilePanel;
    public static JPanel picturePanel;
    public static JPanel descriptionPanel;

    public static String firstNameString = "Owen";
    public static String lastNameString = "Murphy";
    public static String emailString = "owen.murphy@hotmail.org";


    public static JLabel firstNameLabel;
    public static JLabel lastNameLabel;
    public static JLabel emailLabel;
    public static JLabel firstName;
    public static JLabel lastName;
    public static JLabel email;
    public static Font stringFont;

    public static Font labelFont;

    public static JButton changePasswordButton;
    public static JButton changeUsernameButton;
    public static JButton deleteAccountButton;

    public static JPanel getProfilePanel() {
        profilePanel = new JPanel(new BorderLayout());
        labelFont = new Font("Sans-Serif", Font.BOLD, 16);
        stringFont = new Font("Sans-Serif", Font.PLAIN, 16);

        profilePanel.add(getPicturePanel(), BorderLayout.WEST);

        JScrollPane descriptionScrollPanel = new JScrollPane(getDescriptionPanel());
        descriptionScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        profilePanel.add(descriptionScrollPanel, BorderLayout.CENTER);


        return profilePanel;
    }

    public static JPanel getPicturePanel() {
        picturePanel = new JPanel();
        picturePanel.setPreferredSize(new Dimension(150, CenterPanelController.centerPanelHeight));
        picturePanel.setBackground(CenterPanelController.centerPanelColor);

        // FIXME: need to configure for profile picture in the left side of panel

        return picturePanel;
    }

    public static JPanel getDescriptionPanel() {
        descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new GridLayout(1, 2));

        descriptionPanel.add(getFirstNameLabel());
        descriptionPanel.add(getLastNameLabel());
        descriptionPanel.add(getEmailLabel());
        descriptionPanel.setBackground(CenterPanelController.centerPanelColor);

        return descriptionPanel;
    }

    public static JLabel getFirstNameLabel() {
        ProfileSection.firstNameLabel = new JLabel("First Name: " + firstNameString, JLabel.LEFT);

        return firstNameLabel;
    }

    public static void setFirstNameLabel(JLabel firstNameLabel) {

        ProfileSection.firstNameLabel = firstNameLabel;
    }

    public static JLabel getLastNameLabel() {
        ProfileSection.lastNameLabel = new JLabel("Last Name: " + lastNameString, JLabel.LEFT);

        return lastNameLabel;
    }

    public static void setLastNameLabel(JLabel lastNameLabel) {
        ProfileSection.lastNameLabel = lastNameLabel;
    }

    public static JLabel getEmailLabel() {
        ProfileSection.emailLabel = new JLabel("Email: " + emailString, JLabel.LEFT);
        return emailLabel;
    }

    public static void setEmailLabel(JLabel emailLabel) {
        ProfileSection.emailLabel = emailLabel;
    }
}
