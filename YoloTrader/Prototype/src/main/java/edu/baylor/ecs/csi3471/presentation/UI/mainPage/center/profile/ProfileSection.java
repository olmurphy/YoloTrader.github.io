package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.profile;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class ProfileSection {

    /*
    FIXME: NEED TO FINISH DESIGNING THE PROFILE PANEL, UNFINISHED
     */

    public static JPanel profilePanel;
    public static JPanel picturePanel;
    public static JPanel descriptionPanel;
    public static JPanel labelValuePanel;
    public static JPanel buttonPanel;
    public static JScrollPane descriptionScrollPanel;

    public static String firstString = "empty";
    public static String lastString = "empty";
    public static String emailString = "empty";
    public static String userString = "empty";

    public static String emailLabelString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>Email: </B>";
    public static String firstLabelString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>First: </B>";
    public static String lastLabelString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>Last: </B>";
    public static String userLabelString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>Username: </B>";

    public static JLabel firstLabel;
    public static JLabel lastLabel;
    public static JLabel emailLabel;
    public static JLabel userLabel;

    public static JButton changePasswordButton;
    public static JButton changeUsernameButton;
    public static JButton deleteAccountButton;

    public static JLabel picture;

    public static int verticalLabelValueSpace = 30;
    public static int verticalButtonSpace = 20;

    public static JScrollPane getProfilePanel() {
        return descriptionScrollPanel;
    }

    /**
     * setting up the profile panel when the application opens
     * @param profile the user's profile used to get it's fields to set the fields of ${@link ProfileSection}
     */
    public static void setProfilePanel(Profile profile) {
        // initialize the fields of the profile panel upon user entering the application
        setFields(profile.getFirst(), profile.getLast(), profile.getUsername(), profile.getEmail());

        profilePanel = new JPanel(new BorderLayout());
        profilePanel.add(getPicturePanel(), BorderLayout.WEST);
        profilePanel.add(getDescriptionPanel(), BorderLayout.CENTER);

        descriptionScrollPanel = new JScrollPane(profilePanel);
        descriptionScrollPanel.setBorder(BorderFactory.createEmptyBorder());
    }

    public static JPanel getPicturePanel() {
        picturePanel = new JPanel();
        picturePanel.setPreferredSize(new Dimension(150, CenterPanelController.centerPanelHeight));
        picturePanel.setBackground(CenterPanelController.centerPanelColor);

        // FIXME: need to configure for profile picture in the left side of panel
        picturePanel.add(getPicture());

        return picturePanel;
    }

    public static JLabel getPicture() {
        picture = new JLabel();

        ImageIcon icon = new ImageIcon(
                "Prototype/src/main/resources/test.png"
        );
        picture.setIcon(icon);

        return picture;
    }

    public static JPanel getDescriptionPanel() {
        descriptionPanel = new JPanel();
        //descriptionPanel.add(new JLabel("What is going on??"));
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

        descriptionPanel.add(getLabelValuePanel()); // labels w/ associated values

        descriptionPanel.add(getButtonPanel());  // buttons are align vertically, no grid Layout

        descriptionPanel.setBackground(CenterPanelController.centerPanelColor);

        return descriptionPanel;
    }

    public static JPanel getLabelValuePanel() {
        labelValuePanel = new JPanel();
        labelValuePanel.setLayout(new BoxLayout(labelValuePanel, BoxLayout.Y_AXIS));


        // adding first name
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        setFirstLabel(new JLabel(firstLabelString + firstString));
        labelValuePanel.add(getFirstLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));

        // adding last name
        setLastLabel(new JLabel(lastLabelString + lastString));
        labelValuePanel.add(getLastLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));

        // adding username
        setUserLabel(new JLabel(userLabelString + userString));
        labelValuePanel.add(getUserLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));

        // adding email
        setEmailLabel(new JLabel(emailLabelString + emailString));
        labelValuePanel.add(getEmailLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelValuePanel.setBackground(CenterPanelController.centerPanelColor);

        return labelValuePanel;
    }

    public static JPanel getButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(Box.createRigidArea(new Dimension(0, verticalButtonSpace)));
        buttonPanel.add(getChangeUsernameButton());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, verticalButtonSpace)));
        buttonPanel.add(getChangePasswordButton());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, verticalButtonSpace)));
        buttonPanel.add(getDeleteAccountButton());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, verticalButtonSpace)));
        buttonPanel.setBackground(CenterPanelController.centerPanelColor);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        return buttonPanel;
    }

    public static JLabel getFirstLabel() {
        return firstLabel;
    }

    public static JLabel getLastLabel() {
        return lastLabel;
    }

    public static JLabel getEmailLabel() {
        return emailLabel;
    }

    public static JLabel getUserLabel() {
        return userLabel;
    }

    public static JButton getChangeUsernameButton() {
        changeUsernameButton = new JButton("Change Username");
        changeUsernameButton.setHorizontalAlignment(JButton.LEFT);

        // FIXME: need to add action to this in the "Controller"
        // changeUsernameButton.addActionListener();

        return changeUsernameButton;
    }

    public static JButton getChangePasswordButton() {
        changePasswordButton = new JButton("Change Password");
        changePasswordButton.setHorizontalAlignment(JButton.LEFT);

        // FIXME: need to add action to this in the "Controller"
        // changePasswordButton.addActionListener();

        return changePasswordButton;
    }

    public static JButton getDeleteAccountButton() {
        deleteAccountButton = new JButton("Delete Account");
        deleteAccountButton.setHorizontalAlignment(JButton.LEFT);

        // FIXME: need to add action to this in the "Controller"
        // deleteAccountButton.addActionListener();

        return deleteAccountButton;
    }

    public static void setEmailLabel(JLabel emailLabel) {
        ProfileSection.emailLabel = emailLabel;
    }

    public static void setFirstLabel(JLabel firstLabel) {
        ProfileSection.firstLabel = firstLabel;
    }

    public static void setLastLabel(JLabel lastLabel) {
        ProfileSection.lastLabel = lastLabel;
    }

    public static void setUserLabel(JLabel userLabel) {
        ProfileSection.userLabel = userLabel;
    }

    public static void setFirstString(String firstString) {
        ProfileSection.firstString = firstString;
    }

    public static void setLastString(String lastString) {
        ProfileSection.lastString = lastString;
    }

    public static void setEmailString(String emailString) {
        ProfileSection.emailString = emailString;
    }

    public static void setUserString(String userString) {
        ProfileSection.userString = userString;
    }

    /**
     * used to set all the profile panel
     * @param first first name of user
     * @param last last name of user
     * @param email email of user
     * @param user user's username to display
     */
    public static void setFields(String first, String last, String email, String user) {
        ProfileSection.setFirstString(first);
        ProfileSection.setLastString(last);
        ProfileSection.setEmailString(email);
        ProfileSection.setUserString(user);
    }
}
