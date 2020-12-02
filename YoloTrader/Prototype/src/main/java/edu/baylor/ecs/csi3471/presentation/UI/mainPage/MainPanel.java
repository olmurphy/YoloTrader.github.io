package edu.baylor.ecs.csi3471.presentation.ui.mainPage;

import edu.baylor.ecs.csi3471.presentation.ui.form.FormController;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.heading.NorthPanel;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.west.WestPanel;

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
    public static Color backGroundColor = Color.BLACK;

    /**
     * sets the main User Interface panel
     */
    public static void createUI () {
        homeFrame = new JFrame();

        homeFrame.setSize(new Dimension(frameWidth, frameHeight));
        mainPanel = new JPanel(new BorderLayout());

        // initializing all the panels and the fields inside when the frame opens
        MainPanelController.initializeAllPanels();

        WestPanel.creatWestPanel(mainPanel);
        NorthPanel.createNorthPanel(mainPanel);

        homeFrame.add(mainPanel);
        homeFrame.setVisible(true);
        homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /** @return the main panel*/
    public static JPanel getMainPanel() { return mainPanel; }

    /**
     * return the start frame, that is the login page
     */
    public static void getStartFrame() { FormController.getStartFrame(); }

    /**
     * used for closing the home frame when user logs out
     * @return the home frame
     */
    public static JFrame getHomeFrame() { return homeFrame; }
}
