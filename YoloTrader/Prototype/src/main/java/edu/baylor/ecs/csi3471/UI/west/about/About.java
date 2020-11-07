package edu.baylor.ecs.csi3471.UI.west.about;

import edu.baylor.ecs.csi3471.UI.west.WestPanelUtility;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class About {

    public static String aboutButtonString = "ABOUT";
    public static JPanel aboutPanel;


    public static JPanel getAboutPanel() {
        aboutPanel = WestPanelUtility.getEachWestSubPanel();

        JLabel aboutLabel = new JLabel(aboutButtonString, JLabel.CENTER);
        aboutLabel.setFont(WestPanelUtility.panelLabelFonts);
        aboutPanel.add(aboutLabel);
        aboutPanel.setBackground(WestPanelUtility.westPanelColor);
        aboutPanel.addMouseListener(WestPanelUtility.getGeneralWestPanelActions(aboutPanel));
        aboutPanel.addMouseListener(getAboutPanelAction());

        return aboutPanel;
    }

    public static MouseAdapter getAboutPanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                // FIXME: add cool effects
            }
        };
    }

}
