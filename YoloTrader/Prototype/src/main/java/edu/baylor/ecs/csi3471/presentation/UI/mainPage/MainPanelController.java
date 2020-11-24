package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.StockController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.StockWatchListController;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * @author owenmurphy
 */
public class MainPanelController {

    /** stock controller handles events to stock, like add, delete */
    public static StockController stockController;
    public static StockWatchListController stockWatchListController;

    public static ProfileController getProfileController() {
        return FormController.getProfileController();
    }

    /**
     * initializing all everything needed for the application
     */
    public static void initializeAllPanels() {
        // initialize stock controller
        setStockController(new StockController());

        // call panels to initialize themselves
        NorthPanelController.setNorthPanel(FormController.getProfileController().getProfile().getUsername());
        CenterPanelController.setAllCenterPanels(FormController.getProfileController().getProfile());
        WestPanelController.setAllPanels();
    }

    public static void setStockController(StockController stockController) {
        MainPanelController.stockController = stockController;
    }

    public static StockController getStockController() {
        return stockController;
    }

    /**
     * @return the stock watchList controller of the user's stocks
     */
    public static StockWatchListController getStockWatchListController() {
        return stockWatchListController;
    }
}
