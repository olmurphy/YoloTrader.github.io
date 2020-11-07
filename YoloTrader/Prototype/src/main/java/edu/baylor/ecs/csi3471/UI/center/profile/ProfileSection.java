package edu.baylor.ecs.csi3471.UI.center.profile;

import edu.baylor.ecs.csi3471.UI.center.CenterPanelUtility;
import edu.baylor.ecs.csi3471.UI.west.subpanels.Profile;

import javax.swing.*;
import java.awt.*;

public class ProfileSection {

    public static JPanel profilePanel;
    public static JPanel picturePanel;
    public static JPanel descriptionPanel;


    public static JPanel getProfilePanel() {
        profilePanel = new JPanel(new BorderLayout());

        profilePanel.add(getPicturePanel(), BorderLayout.WEST);

        JScrollPane descriptionScrollPanel = new JScrollPane(getDescriptionPanel());
        descriptionScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        profilePanel.add(descriptionScrollPanel, BorderLayout.CENTER);



        return profilePanel;
    }

    public static JPanel getPicturePanel() {
        picturePanel = new JPanel();
        picturePanel.setPreferredSize(new Dimension(75, CenterPanelUtility.centerPanelHeight));

        // FIXME: need to configure for profile picture in the left side of panel

        return picturePanel;
    }

    public static String firstNameString = "Owen";
    public static String lastNameString = "Murphy";
    public static String emailString = "owen.murphy@hotmail.org";
    public static JLabel firstNameLabel;
    public static JLabel lastNameLabel;
    public static JLabel emailLabel;



    public static JButton changePasswordButton;
    public static JButton changeUsernameButton;
    public static JButton deleteAccountButton;


    public static JPanel getDescriptionPanel() {
        descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

        descriptionPanel.add(getFirstNameLabel());
        descriptionPanel.add(getLastNameLabel());
        descriptionPanel.add(getEmailLabel());

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
