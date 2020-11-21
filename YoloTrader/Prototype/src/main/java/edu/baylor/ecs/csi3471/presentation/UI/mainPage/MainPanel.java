package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanel;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.StockWatchListController;

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

    public static StockWatchListController stockWatchListController;

    public static void createUI () {
        homeFrame = new JFrame();

        homeFrame.setSize(new Dimension(frameWidth, frameHeight));
        mainPanel = new JPanel(new BorderLayout());

        homeFrame.addWindowListener(MainPanelController.getMainFrameListener());
        MainPanelController.initializeAllPanels();

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

        stockWatchListController = new StockWatchListController();
        stockWatchListController.setListStockWatchList(profile.getWatchLists());
        CenterPanelController.setAllFields();
    }

    public static StockWatchListController getStockWatchListController() {
        return stockWatchListController;
    }

    /**
     * used for closing the home frame when user logs out
     * @return the home frame
     */
    public static JFrame getHomeFrame() {
        return homeFrame;
    }
}
