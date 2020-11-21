package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Name;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Search;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.SearchResults;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

/**
 * @author owenmurphy
 */
public class NorthPanelController {

    public static int northPanelWidth = MainPanel.frameWidth;
    public static int northPanelHeight = 120;
    public static Color northPanelColor = MainPanel.backGroundColor;

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


    public static void setName(String name) {
        Name.setName(name);
    }

    /**
     * The launchSearch function either opens a new tab of the desired
     * stock, or opens a new tab of a list of stocks to choose from.
     * <p>
     * @return	returns a ${@link StockUtil} titled Search.
     */
    public static void launchSearch(String query) {

        // result is  a mapping of company name -> ticker.
        Map<String, String> results = StockUtil.pullUp(query);

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
                String stock = SearchResults.getStockList().getSelectedValue().toString();
                listName = SearchResults.getInputWatchListNameToAdd();
                System.out.println("adding " + stock + " to " + listName);
            }
            System.out.println();
        };
    }

    public static ActionListener getLogoutButtonListener() {
        return e -> {
            YoloTrader.logger.info("logging out");
            MainPanel.getHomeFrame().dispose();

            MainPanel.getStartFrame();
        };
    }
}
