package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.StockController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.StockWatchListController;

/**
 * @author owenmurphy
 */
public class MainPanelController {

    /** stock controller handles events to stock item */
    public static StockController stockController;

    /** watch list controllers handles events to watch list */
    public static StockWatchListController stockWatchListController;

    /** controller that the form controller uses to control the creating a new profile and logging into existing */
    private static ProfileController profileController;

    /**
     * initializing all everything needed for the application
     */
    public static void initializeAllPanels() {
        // initialize stock and watch list controllers
        setStockController(new StockController());
        stockWatchListController = new StockWatchListController();
        stockWatchListController.loadStockLists(profileController.getProfile().getWatchLists());

        // call panels to initialize themselves
        NorthPanelController.setNorthPanel(profileController.getProfile().getUsername());
        CenterPanelController.setAllCenterPanels(profileController.getProfile());
        WestPanelController.setAllPanels();
    }

    public static void setStockController(StockController stockController) {
        MainPanelController.stockController = stockController;
    }

    public static StockController getStockController() { return stockController; }

    /**
     * @return the stock watchList controller of the user's stocks
     */
    public static StockWatchListController getStockWatchListController() { return stockWatchListController; }

    public static ProfileController getProfileController() { return profileController; }

    public static void initializeProfileController() {
        profileController = new ProfileController(null);
        profileController.loadProfiles();
    }


}
