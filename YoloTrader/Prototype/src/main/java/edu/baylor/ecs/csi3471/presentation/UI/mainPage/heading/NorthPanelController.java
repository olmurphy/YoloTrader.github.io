package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.stocks.StocksSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Name;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Search;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.SearchResults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
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
                launchSearch(Search.getSearchTextField().getText());
                System.out.println(Search.getSearchTextField().getText());
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
     */
    public static void launchSearch(String query) {

        // result is  a mapping of company name -> ticker.
        results = StockUtil.pullUp(query);

        if (results.size() == 0) {
            SearchResults.getNoResultsWarning();
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
                String stockString = SearchResults.getStockList().getSelectedValue().toString();
                listName = SearchResults.getInputWatchListNameToAdd();

                // find if list exists
                boolean listExists = false;
                int index;
                List<StockWatchList> list = MainPanelController.getProfileController().getProfile().getWatchLists();
                for (index = 0; index < list.size() && !listExists; index++) {
                    if (list.get(index).getName().equals(listName)) {
                        listExists = true;
                    }
                }

                // check if the list exists
                if (listExists) {
                    Stock stock = new Stock(stockString, results.get(stockString), new Date());

                    if (MainPanelController.getStockController().addStock(stock, list.get(index))) {

                        SearchResults.getStockAddedSuccessfullyMessage();

                       YoloTrader.logger.info("adding " + stockString + " to " + listName);
                    } else {
                        SearchResults.getStockAlreadyAddedWarning();
                    }
                } else {
                    // display error that the list does not exist
                    SearchResults.getListNotExistWarning();
                }
            }
            System.out.println();
        };
    }

    /**
     * adds logic to the logout button in the main frame
     * the user logs out, the frame is disposed with all the information saved in the database
     * @return ActionListener for the logout button when it is pressed
     */
    public static ActionListener getLogoutButtonListener() {
        return e -> {
            YoloTrader.logger.info("logging out");
            MainPanel.getHomeFrame().dispose();

            MainPanel.getStartFrame();
        };
    }
}
