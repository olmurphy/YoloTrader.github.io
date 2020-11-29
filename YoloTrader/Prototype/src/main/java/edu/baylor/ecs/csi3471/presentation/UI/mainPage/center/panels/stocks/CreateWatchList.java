package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks;

import javax.swing.*;

/**
 * @author owenmurphy
 */
public class CreateWatchList {

    public static String watchListNameWindow() { return JOptionPane.showInputDialog("Enter watch list name:"); }

    public static void getWatchListNameTaken() {
        JOptionPane.showMessageDialog(null, "Name Taken",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
