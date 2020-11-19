package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

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

        homeFrame.addWindowFocusListener(MainPanelController.getMainFrameAction());

        initializeAllFieldsInMainPanel();

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

    public static void initializeAllFieldsInMainPanel() {
        Profile profile = FormController.getProfileController().getProfile();

        NorthPanelController.setName(profile.getUsername());
        CenterPanelController.setFirst(profile.getFirst());
        CenterPanelController.setLast(profile.getLast());
        CenterPanelController.setUser(profile.getUsername());
        CenterPanelController.setEmail(profile.getEmail());
    }
}
