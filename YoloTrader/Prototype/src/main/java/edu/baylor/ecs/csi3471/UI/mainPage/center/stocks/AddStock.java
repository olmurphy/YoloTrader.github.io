package edu.baylor.ecs.csi3471.UI.mainPage.center.stocks;

import javax.swing.*;

public class AddStock {

    // FIXME: This window will perform similarly to the "Search" a stock
    // FIXME: just with another place to add a stock

    public static void getWarningMessage() {
        JOptionPane.showMessageDialog(null, "Need to select a watchList to add to",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
