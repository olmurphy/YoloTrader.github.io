package edu.baylor.ecs.csi3471.UI;

import edu.baylor.ecs.csi3471.UI.north.NorthPanel;
import edu.baylor.ecs.csi3471.UI.west.WestPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel {


    public static JFrame homeFrame;
    public static int frameWidth = 700;
    public static int frameHeight = 500;
    public static JPanel mainPanel;

    public static void createUI () {
        homeFrame = new JFrame();
        homeFrame.setSize(new Dimension(frameWidth, frameHeight));
        mainPanel = new JPanel(new BorderLayout());


        WestPanel.creatWestPanel(mainPanel);
        NorthPanel.createNorthPanel(mainPanel);

        homeFrame.add(mainPanel);
        homeFrame.setVisible(true);
        homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
