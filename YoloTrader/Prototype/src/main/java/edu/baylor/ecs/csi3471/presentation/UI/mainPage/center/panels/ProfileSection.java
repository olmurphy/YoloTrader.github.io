package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class ProfileSection {

    public static JScrollPane descriptionScrollPanel;

    public static String emailLabelString = "<html><span style=\"font-family:Futura;font-size:14px;color:white;\"><B>Email: </B>";
    public static String firstLabelString = "<html><span style=\"font-family:Futura;font-size:14px;color:white;\"><B>First: </B>";
    public static String lastLabelString = "<html><span style=\"font-family:Futura;font-size:14px;color:white;\"><B>Last: </B>";
    public static String userLabelString = "<html><span style=\"font-family:Futura;font-size:14px;color:white;\"><B>Username: </B>";

    public static String startUserFieldsFormat = "<span style=\"font-family:Futura;font-size:14px;color:white;\">";

    public static JLabel firstLabel;
    public static JLabel lastLabel;
    public static JLabel userLabel;
    public static JLabel emailLabel;

    public static JLabel picture;

    public static int verticalLabelValueSpace = 30;
    public static int verticalButtonSpace = 20;

    public static boolean set = false;

    public static JScrollPane getProfilePanel() { return descriptionScrollPanel; }

    /**
     * setting up the profile panel when the application opens
     * @param profile the user's profile used to get it's fields to set the fields of ${@link ProfileSection}
     */
    public static void setProfilePanel(Profile profile) {
        // initialize the fields of the profile panel upon user entering the application
        addTextToProfileLabels(profile.getFirst(), profile.getLast(), profile.getUsername(), profile.getEmail());

        JPanel profilePanel = new JPanel(new BorderLayout());
        profilePanel.add(getPicturePanel(), BorderLayout.WEST);
        profilePanel.add(getDescriptionPanel(), BorderLayout.CENTER);

        descriptionScrollPanel = new JScrollPane(profilePanel);
        descriptionScrollPanel.setBorder(BorderFactory.createEmptyBorder());
    }

    public static JPanel getPicturePanel() {
        JPanel picturePanel = new JPanel();
        picturePanel.setPreferredSize(new Dimension(150, CenterPanelController.centerPanelHeight));
        picturePanel.setBackground(CenterPanelController.centerPanelColor);

        picturePanel.add(getPicture());

        return picturePanel;
    }

    public static JLabel getPicture() {
        JLabel picture = new JLabel();

        ImageIcon icon = new ImageIcon("Prototype/src/main/resources/test.png");
        picture.setIcon(icon);

        return picture;
    }

    public static JPanel getDescriptionPanel() {
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.setBackground(CenterPanelController.centerPanelColor);

        descriptionPanel.add(getLabelValuePanel()); // labels w/ associated values

        descriptionPanel.add(getButtonPanel());  // buttons are align vertically, no grid Layout

        return descriptionPanel;
    }

    public static JPanel getLabelValuePanel() {
        JPanel labelValuePanel = new JPanel();
        labelValuePanel.setLayout(new BoxLayout(labelValuePanel, BoxLayout.Y_AXIS));

        // adding edit profile button
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelValuePanel.add(getEditProfileButton());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));

        // adding first name
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelValuePanel.add(getFirstLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));

        // adding last name
        labelValuePanel.add(getLastLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));

        // adding username
        labelValuePanel.add(getUserLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));

        // adding email
        labelValuePanel.add(getEmailLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelValuePanel.setBackground(CenterPanelController.centerPanelColor);

        return labelValuePanel;
    }

    public static JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(Box.createRigidArea(new Dimension(0, verticalButtonSpace)));
        buttonPanel.add(getChangePasswordButton());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, verticalButtonSpace)));
        buttonPanel.add(getDeleteAccountButton());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, verticalButtonSpace)));
        buttonPanel.setBackground(CenterPanelController.centerPanelColor);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        return buttonPanel;
    }

    public static JLabel getFirstLabel() { return firstLabel; }

    public static JLabel getLastLabel() { return lastLabel; }

    public static JLabel getEmailLabel() { return emailLabel; }

    public static JLabel getUserLabel() { return userLabel; }

    public static JButton getEditProfileButton() {
        JButton editProfileButton = new JButton(CenterPanelController.leftButtonSide + "Edit Profile" +
                CenterPanelController.rightButtonSide);
        editProfileButton.setHorizontalAlignment(JButton.LEFT);
        editProfileButton.setBackground(CenterPanelController.centerPanelColor);
        editProfileButton.setBorder(CenterPanelController.emptyButtonBorder);

        // adding action
        editProfileButton.addActionListener(CenterPanelController.getEditProfileListener());

        // adding UI effects
        editProfileButton.addMouseListener(CenterPanelController.getGeneralButtonAction(editProfileButton));

        return editProfileButton;
    }

    public static JButton getChangePasswordButton() {
        JButton changePasswordButton = new JButton(CenterPanelController.leftButtonSide + "Change Password" +
                CenterPanelController.rightButtonSide);
        changePasswordButton.setHorizontalAlignment(JButton.LEFT);
        changePasswordButton.setBackground(CenterPanelController.centerPanelColor);
        changePasswordButton.setBorder(CenterPanelController.emptyButtonBorder);

        changePasswordButton.addActionListener(CenterPanelController.getChangePasswordListener());
        changePasswordButton.addMouseListener(CenterPanelController.getGeneralButtonAction(changePasswordButton));

        return changePasswordButton;
    }

    public static JButton getDeleteAccountButton() {
        JButton deleteAccountButton = new JButton(CenterPanelController.leftButtonSide + "Delete Account" +
                CenterPanelController.rightButtonSide);
        deleteAccountButton.setHorizontalAlignment(JButton.LEFT);
        deleteAccountButton.setBackground(CenterPanelController.centerPanelColor);
        deleteAccountButton.setBorder(CenterPanelController.emptyButtonBorder);

        deleteAccountButton.addActionListener(CenterPanelController.getDeleteAccountListener());
        deleteAccountButton.addMouseListener(CenterPanelController.getGeneralButtonAction(deleteAccountButton));

        return deleteAccountButton;
    }

    /**
     * used to set all the profile panel
     * @param first first name of user
     * @param last last name of user
     * @param email email of user
     * @param user user's username to display
     */
    public static void addTextToProfileLabels(String first, String last, String user, String email) {

        if (!set) { setAllProfileLabels(); }

        // setting first name
        getFirstLabel().setText(firstLabelString + startUserFieldsFormat + first);

        // adding last name
        getLastLabel().setText(lastLabelString + startUserFieldsFormat + last );

        // adding username
        getUserLabel().setText(userLabelString + startUserFieldsFormat + user );

        // adding email
        getEmailLabel().setText(emailLabelString + startUserFieldsFormat + email);
    }

    public static void setAllProfileLabels() {
        set = true;
        firstLabel  = new JLabel();
        lastLabel   = new JLabel();
        userLabel   = new JLabel();
        emailLabel  = new JLabel();
    }
}