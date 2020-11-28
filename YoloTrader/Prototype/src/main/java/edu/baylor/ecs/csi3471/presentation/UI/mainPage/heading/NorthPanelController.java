package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Name;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Search;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.SearchResults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author owenmurphy
 */
public class NorthPanelController {

    public static int northPanelWidth = MainPanel.frameWidth;
    public static int northPanelHeight = 120;
    public static Color northPanelColor = MainPanel.backGroundColor;
    public static Map<String, String> results;

    /** used in ${@link #getAddStockButtonListener()} to determine if the user wanted to add a stock
     * directly to the selected watch list (rather than just look up stocks) */
    public static boolean searchStock;

    /**
     * initialize the "Welcome, name" upon creating an account or logging in
     */
    public static void setNorthPanel(String user) {
        setName(user);
    }

    /**
     * logic for search button, it calls the launchSearch which makes an indirect call to the StockUtil
     * class to communicate with the API
     * @param search the company name or ticker to search for
     * @return ActionListener to listen for when the button is pressed
     */
    public static ActionListener getSearchButtonAction(JTextField search) {
        return e -> {
            if (search.getText().equals("")) {
                Search.getSearchWarning();
            } else {
                YoloTrader.logger.info("Searching stock...");

                // 2nd parameter is false because all we want is to display the results from the query,
                // not adding anything, refer to lauchSearch() description
                launchSearch(Search.getSearchTextField().getText(), false);
            }
        };
    }

    /**
     * sets the name on the top of the panel to username
     * @param name username of the user entering application
     */
    public static void setName(String name) {
        Name.setName(name);
    }

    /**
     * The launchSearch function either opens a new tab of the desired
     * stock, or opens a new tab of a list of stocks to choose from.
     * <p>
     * returns a ${@link StockUtil} titled Search.
     * @param query stock to search in the API
     * @param addSingleStock true if the action came from 'Add Stock' ${@link CenterPanelController}
     *                       else false
     */
    public static void launchSearch(String query, boolean addSingleStock) {

        searchStock = addSingleStock; // indicates if add stock directly to watch list

        // results is  a mapping of company name -> ticker.
        results = StockUtil.pullUp(query);

        if (results.size() == 0) {
            SearchResults.getNoResultsWarning();
        } else if (addSingleStock && results.size() == 1) {

            // get the stock watch list
            StockWatchList list = MainPanelController.getStockWatchListController()
                    .findStockWatchList(CenterPanelController.getWatchListJList().getSelectedValue());

            // getting the only result found
            Map.Entry<String, String> entry = results.entrySet().iterator().next();

            // adding the stock to the list
            MainPanelController.getStockController().addStock(new Stock(entry.getKey(), entry.getValue(), new Date()), list);

            // save to database
            MainPanelController.getProfileController().saveProfiles();

            // update the list
            CenterPanelController.updateStockListModel();
        } else {

            // adding the results to the stock model
            DefaultListModel<String> model = new DefaultListModel<>();
            Set<String> set = results.keySet();
            set.forEach(model::addElement);
            SearchResults.setStockModel(model);
            SearchResults.startSearchDialog();
        }
    }

    /**
     * setting action performed for the add stock button
     * @return ActionListener for the Add Stock button
     */
    public static ActionListener getAddStockButtonListener() {
        return e -> {

            String listName;
            if (SearchResults.getStockList().isSelectionEmpty()) {
                SearchResults.getNoStockSelectedWarning();
            } else {
                String stockString = SearchResults.getStockList().getSelectedValue();
                Stock stock = new Stock(stockString, results.get(stockString), new Date());

                if (searchStock) { // case that the user wants to add the stock directly to the watch list selected

                    // logging the action
                    YoloTrader.logger.info("directly adding stock to watch list");

                    // getting the selected watch list
                    String listName1 = CenterPanelController.getWatchListJList().getSelectedValue();

                    // getting the stock watch list selected
                    StockWatchList watchList = MainPanelController.getStockWatchListController().findStockWatchList(listName1);

                    // adding the stock to the stock watch list
                    MainPanelController.getStockController().addStock(stock, watchList);

                    // save to database
                    MainPanelController.getProfileController().saveProfiles();

                    // update the stock list model
                    CenterPanelController.updateStockListModel();

                    // send successful message
                    SearchResults.getStockAddedSuccessfullyMessage();
                } else {


                    listName = SearchResults.getInputWatchListNameToAdd();

                    // find the watchList
                    StockWatchList watchList = MainPanelController.getStockWatchListController().findStockWatchList(listName);

                    if (watchList != null) {

                        if (MainPanelController.getStockController().addStock(stock, watchList)) {
                            // log action
                            YoloTrader.logger.info("adding " + stockString + " to " + listName);

                            // save to database
                            MainPanelController.getProfileController().saveProfiles();

                            // update the stock list model
                            CenterPanelController.updateStockListModel();

                            // send successful message
                            SearchResults.getStockAddedSuccessfullyMessage();
                        } else {
                            SearchResults.getStockAlreadyAddedWarning();
                        }
                    } else {
                        // display error that the list does not exist
                        SearchResults.getListNotExistWarning();
                    }
                }
            }
        };
    }

    /**
     * adds logic to the logout button in the main frame
     * the user logs out, the frame is disposed with all the information saved in the database
     * @return ActionListener for the logout button when it is pressed
     */
    public static ActionListener getLogoutButtonListener() {
        return e -> {
            YoloTrader.logger.info("logging out...");
            MainPanel.getHomeFrame().dispose();

            MainPanel.getStartFrame();
        };
    }

    /**
     * adds the listener to the open stock button to display a panel
     * @return ActionListner for when the open stock button is clicked
     */
    public static ActionListener getOpenStockButtonListener() {
        return e -> {
            if (SearchResults.getStockList().isSelectionEmpty()) {
                // no stock selected, display warning
                SearchResults.getNoStockSelectedWarning();
            } else {
                // open the stock panel FIXME: need to add open graph panel
                System.out.println(SearchResults.getStockList().getSelectedValue());
            }
        };
    }
}
