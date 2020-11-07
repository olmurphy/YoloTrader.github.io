package edu.baylor.ecs.csi3471.UI.west.home;

import edu.baylor.ecs.csi3471.UI.west.WestPanelUtility;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

    public static String homeButtonString = "HOME";
    public static JPanel homePanel;

    public static JPanel getHomePanel() {
        homePanel = WestPanelUtility.getEachWestSubPanel();

        JLabel homeLabel = new JLabel(homeButtonString, JLabel.CENTER);
        homeLabel.setFont(WestPanelUtility.panelLabelFonts);
        homePanel.add(homeLabel);
        homePanel.addMouseListener(WestPanelUtility.getGeneralWestPanelActions(homePanel));
        homePanel.addMouseListener(getHomePanelAction());


        homePanel.setBackground(WestPanelUtility.westPanelColor);

        return homePanel;
    }

    public static MouseAdapter getHomePanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                // FIXME: perform action here
            }
        };
    }







}
