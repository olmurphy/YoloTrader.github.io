package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.stocks;

import javax.swing.*;

/**
 * @author owenmurphy
 */
public class AddStock {

    // FIXME: This window will perform similarly to the "Search" a stock
    // FIXME: just with another reference place to add a stock

    /**
     * displays warning if the user has not selected watch list to perform an action on
     */
    public static void getNoWatchListSelectedWarning() {
        JOptionPane.showMessageDialog(null, "Need to select a watchList to add to",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
