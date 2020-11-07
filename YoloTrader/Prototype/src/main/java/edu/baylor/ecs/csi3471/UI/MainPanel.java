package edu.baylor.ecs.csi3471.UI;

import edu.baylor.ecs.csi3471.UI.heading.NorthPanel;
import edu.baylor.ecs.csi3471.UI.west.WestPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel {


    public static JFrame homeFrame;
    public static int frameWidth = 700;
    public static int frameHeight = 500;
    public static JPanel mainPanel;

    public static void createUI (String name) {
        homeFrame = new JFrame();
        homeFrame.setSize(new Dimension(frameWidth, frameHeight));
        mainPanel = new JPanel(new BorderLayout());

        WestPanel.creatWestPanel(mainPanel);
        NorthPanel.createNorthPanel(mainPanel, name);

        homeFrame.add(mainPanel);
        homeFrame.setVisible(true);
        homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }
}
