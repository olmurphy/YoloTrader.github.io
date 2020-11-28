package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class Name {

    private static String name;
    public  static JPanel welcomePanel;
    public static JPanel labelPanel;
    public static JButton logoutButton;

    public static JPanel getWelcomePanel() {
        welcomePanel = new JPanel(new GridLayout(1, 1));

        welcomePanel.add(getLabelPanel());
        welcomePanel.setBackground(NorthPanelController.northPanelColor);

        return welcomePanel;
    }

    public static JPanel getLabelPanel() {
        labelPanel = new JPanel(new BorderLayout());
        labelPanel.setBackground(NorthPanelController.northPanelColor);

        labelPanel.add(getLabel(name), BorderLayout.WEST);

        setLogoutButton(new JButton(NorthPanelController.leftLabelSide + "Logout" +
                NorthPanelController.rightLabelSide));
        labelPanel.add(getLogoutButton(), BorderLayout.EAST);

        return labelPanel;
    }

    public static JLabel getLabel(String name) {
        Name.name = name;
        JLabel welcomeLabel = new JLabel(NorthPanelController.leftLabelSide + "Welcome, "
                + Name.name + "!" + NorthPanelController.rightLabelSide, JLabel.LEFT);
        welcomeLabel.setBackground(NorthPanelController.northPanelColor);

        return welcomeLabel;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Name.name = name;
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

    public static JButton getLogoutButton() {
        return logoutButton;
    }
}
