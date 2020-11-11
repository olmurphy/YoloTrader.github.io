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

    public static String firstString = "Owen";
    public static String lastString = "Murphy";
    public static String emailString = "owen.murphy@hotmail.org";
    public static String userString = "olmurphy";

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
        profilePanel = new JPanel(new BorderLayout());
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
        descriptionPanel.add(new JLabel("What is going on??"));

        descriptionPanel.setBackground(CenterPanelController.centerPanelColor);

        return descriptionPanel;
    }

    public static JPanel getLabelValuePanel() {
        labelValuePanel = new JPanel();
        labelValuePanel.setLayout(new BoxLayout(labelValuePanel, BoxLayout.Y_AXIS));

        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelValuePanel.add(getFirstLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelValuePanel.add(getLastLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
        labelValuePanel.add(getUserLabel());
        labelValuePanel.add(Box.createRigidArea(new Dimension(0, verticalLabelValueSpace)));
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
        firstLabel = new JLabel(firstLabelString + firstString);
        return firstLabel;
    }

    public static JLabel getLastLabel() {
        lastLabel = new JLabel(lastLabelString + lastString);
        return lastLabel;
    }


    public static JLabel getEmailLabel() {
        emailLabel = new JLabel(emailLabelString + emailString);
        return emailLabel;
    }

    public static JLabel getUserLabel() {
        userLabel = new JLabel(userLabelString + userString);
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

    public static void setEmailLabel() {
        emailLabel.setText(emailLabelString + emailString);
    }

    public static void setFirstLabel() {
        firstLabel.setText(firstLabelString + lastString);
    }

    public static void setLastLabel() {
        lastLabel.setText(lastLabelString + lastString);
    }

    public static void setUserLabel() {
        ProfileSection.userLabel.setText(userLabelString + userString);
    }
}
