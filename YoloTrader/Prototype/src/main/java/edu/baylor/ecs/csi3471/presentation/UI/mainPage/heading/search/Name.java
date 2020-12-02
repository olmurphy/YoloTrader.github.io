package edu.baylor.ecs.csi3471.presentation.ui.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.ui.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class Name {

    public static JButton logoutButton;
    public static JLabel welcomeLabel;
    public static JPanel welcomePanel;

    public static boolean set = false;

    public static void setWelcomePanel(String name) {
        welcomePanel = new JPanel(new GridLayout(1, 1));

        updateLabelPanel(name);
        welcomePanel.add(getLabelPanel());
        welcomePanel.setBackground(NorthPanelController.northPanelColor);
    }

    public static void updateLabelPanel(String name) {
        if (!set) { setWelcomeLabel(); }

        getLabel().setText(NorthPanelController.leftLabelSide + "Welcome, " + name + "!" + NorthPanelController.rightLabelSide);
    }

    public static void setWelcomeLabel() {
        set = true;
        Name.welcomeLabel = new JLabel();
        welcomeLabel.setBackground(NorthPanelController.northPanelColor);
    }

    public static JPanel getLabelPanel() {
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.setBackground(NorthPanelController.northPanelColor);

        labelPanel.add(getLabel(), BorderLayout.WEST); // add label

        setLogoutButton(new JButton(NorthPanelController.leftLabelSide + "Logout" + NorthPanelController.rightLabelSide));
        labelPanel.add(getLogoutButton(), BorderLayout.EAST);

        return labelPanel;
    }

    public static void setLogoutButton(JButton logoutButton) {
        Name.logoutButton = logoutButton;
        Name.logoutButton.setHorizontalAlignment(JButton.RIGHT);

        Name.logoutButton.setBackground(NorthPanelController.northPanelColor);
        Name.logoutButton.setBorder(NorthPanelController.emptyButtonBorder);
        Name.logoutButton.setOpaque(true);

        // adding listeners
        Name.logoutButton.addActionListener(NorthPanelController.getLogoutButtonListener());
        Name.logoutButton.addMouseListener(NorthPanelController.getGeneralButtonListener(logoutButton));
    }

    public static JPanel getWelcomePanel() { return welcomePanel; }

    public static JButton getLogoutButton() { return logoutButton; }

    public static JLabel getLabel() { return welcomeLabel; }
}
