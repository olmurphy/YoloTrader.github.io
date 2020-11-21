package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading;

import edu.baylor.ecs.csi3471.API.StockUtil;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Name;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Search;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

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
     * @return	returns a ${@link JButton} titled Search.
     */
    public static void launchSearch(String query) {

        //results is  a mapping of company name -> ticker.
        Map<String, String> results = StockUtil.pullUp(query);

        String tabTitle = "Search: " + query;

        JPanel resultTab = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Results: ");
        JLabel matches = new JLabel();

        String resultDisplay;

        resultTab.add(title, BorderLayout.NORTH);
        resultTab.add(matches);


        //If there was an exact match.
        if(results.size()  == 1) {
            //TODO:
            //should just pull open a new tab of that stock.
            matches.setText(results.toString());
        }

        //If there were more than one match.
        else if(results.size() > 1) {
            //TODO:
            //should show all options from user to pick from.
            System.out.print(results.toString());
            resultDisplay = results.toString().replaceAll(",", "[ ]\n");
            matches.setText(resultDisplay);
        }

        // Otherwise, no matches.
        else {
            matches.setText("No Results, try rephrasing your search!");
        }

        // MainPanel.newTab(tabTitle, resultTab);

        System.out.println(results);

    }
}
