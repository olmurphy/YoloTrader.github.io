package edu.baylor.ecs.csi3471.UI.mainPage.center.profile;

import edu.baylor.ecs.csi3471.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;

public class ProfileSection {

    /*
    FIXME: NEED TO FINISH DESIGNING THE PROFILE PANEL, UNFINISHED
     */


    public static JPanel profilePanel;
    public static JPanel picturePanel;
    public static JPanel descriptionPanel;
    public static JPanel labelValuePanel;
    public static JPanel buttonPanel;

    public static String firstNameString = "Owen";
    public static String lastNameString = "Murphy";
    public static String emailString = "owen.murphy@hotmail.org";

    public static Component spaceBetweenLabels;

    public static JLabel firstNameLabel;
    public static JLabel lastNameLabel;
    public static JLabel emailLabel;
    public static JLabel firstNameValue;
    public static JLabel lastNameValue;
    public static JLabel emailValue;

    public static Font valueFont;
    public static Font labelFont;

    public static JButton changePasswordButton;
    public static JButton changeUsernameButton;
    public static JButton deleteAccountButton;

    public static int verticalLabelValueSpace = 30;
    public static int verticalButtonSpace = 20;

    public static JScrollPane getProfilePanel() {
        profilePanel = new JPanel(new BorderLayout());
        labelFont = new Font("Sans-Serif", Font.BOLD, 14);
        valueFont = new Font("Sans-Serif", Font.PLAIN, 14);

        profilePanel.add(getPicturePanel(), BorderLayout.WEST);
        profilePanel.add(getDescriptionPanel(), BorderLayout.CENTER);

        JScrollPane descriptionScrollPanel = new JScrollPane(profilePanel);
        descriptionScrollPanel.setBorder(BorderFactory.createEmptyBorder());


        return descriptionScrollPanel;
    }

    public static JPanel getPicturePanel() {
        picturePanel = new JPanel();
        picturePanel.setPreferredSize(new Dimension(150, CenterPanelController.centerPanelHeight));
        picturePanel.setBackground(CenterPanelController.centerPanelColor);

        // FIXME: need to configure for profile picture in the left side of panel
        picturePanel.add(new JLabel("Profile pic goes here")); // test, delete later

        return picturePanel;
    }

    public static JPanel getDescriptionPanel() {
        descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

        descriptionPanel.add(getLabelValuePanel()); // labels w/ associated values
        //descriptionPanel.add(getButtonPanel());  // buttons are align vertically, no grid Layout
        descriptionPanel.add(new JLabel("What is going on??"));

        descriptionPanel.setBackground(CenterPanelController.centerPanelColor);

        return descriptionPanel;
    }

    public static JPanel getLabelValuePanel() {
        labelValuePanel = new JPanel(/*new GridLayout(0, 2)*/);

        labelValuePanel.add(getLabelPanelOnDescriptionPanel());// left side w/ labels
        labelValuePanel.add(getValuePanelOnDescriptionPanel());// right side w/ values of associated labels

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

        return buttonPanel;
    }

    public static JPanel getLabelPanelOnDescriptionPanel() {
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        labelPanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelPanel.add(getFirstNameLabel());
        labelPanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelPanel.add(getLastNameLabel());
        labelPanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelPanel.add(getEmailLabel());
        //labelPanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelPanel.setBackground(CenterPanelController.centerPanelColor);

        return labelPanel;
    }

    public static JPanel getValuePanelOnDescriptionPanel() {
        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.Y_AXIS));

        // FIXME: SET TO 'VALUE' labels
        valuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        valuePanel.add(getFirstNameValue());
        valuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        valuePanel.add(getLastNameValue());
        valuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        valuePanel.add(getEmailValue());
        //valuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        valuePanel.setBackground(CenterPanelController.centerPanelColor);

        return valuePanel;
    }

    public static JLabel getFirstNameLabel() {
        firstNameLabel = new JLabel("First Name: ", JLabel.LEFT);
        firstNameLabel.setFont(labelFont);

        return firstNameLabel;
    }

    public static JLabel getFirstNameValue() {

        // FIXME: need to configure for when user logs in in
        firstNameValue = new JLabel(firstNameString);
        firstNameValue.setFont(valueFont);

        return firstNameValue;
    }

    public static JLabel getLastNameLabel() {
        lastNameLabel = new JLabel("Last Name: ", JLabel.LEFT);
        lastNameLabel.setFont(labelFont);

        return lastNameLabel;
    }

    public static JLabel getLastNameValue() {

        // FIXME: need to configure for when user logs in in
        lastNameValue = new JLabel(lastNameString);
        lastNameValue.setFont(valueFont);

        return lastNameValue;
    }

    public static JLabel getEmailLabel() {
        emailLabel = new JLabel("Email: ", JLabel.RIGHT);
        emailLabel.setFont(labelFont);

        return emailLabel;
    }

    public static JLabel getEmailValue() {

        // FIXME: need to configure for when user logs in in
        emailValue = new JLabel(emailString);
        emailValue.setFont(valueFont);

        return emailValue;
    }

    public static JButton getChangeUsernameButton() {
        changeUsernameButton = new JButton("Change Username");

        return changeUsernameButton;
    }

    public static JButton getChangePasswordButton() {
        changePasswordButton = new JButton("Change Password");

        return changePasswordButton;
    }

    public static JButton getDeleteAccountButton() {
        deleteAccountButton = new JButton("Delete Account");

        return deleteAccountButton;
    }


}
