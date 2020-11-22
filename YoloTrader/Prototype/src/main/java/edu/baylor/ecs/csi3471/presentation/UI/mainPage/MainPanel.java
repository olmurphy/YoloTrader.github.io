package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class MainPanel {

    public static JFrame homeFrame;
    public static int frameWidth = 800;
    public static int frameHeight = 600;
    public static JPanel mainPanel;
    public static Color backGroundColor = Color.lightGray;


    public static void createUI () {
        homeFrame = new JFrame();

        homeFrame.setSize(new Dimension(frameWidth, frameHeight));
        mainPanel = new JPanel(new BorderLayout());

        // adding the window listener when application exits to save the info
        homeFrame.addWindowListener(MainPanelController.getMainFrameListener());

        // initializing all the panels and the fields inside when the frame opens
        MainPanelController.initializeAllPanels();

        // setting all the fields in the panel
        // MainPanelController.initializeAllFieldsInMainPanel();

        WestPanel.creatWestPanel(mainPanel);
        NorthPanel.createNorthPanel(mainPanel);

        homeFrame.add(mainPanel);
        homeFrame.setVisible(true);
        homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }

    /* low coupling */
    public static void getStartFrame() {
        FormController.getStartFrame();
    }


    /**
     * used for closing the home frame when user logs out
     * @return the home frame
     */
    public static JFrame getHomeFrame() {
        return homeFrame;
    }
}
