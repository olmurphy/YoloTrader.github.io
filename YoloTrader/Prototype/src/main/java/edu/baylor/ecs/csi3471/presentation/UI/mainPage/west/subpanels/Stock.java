package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class Stock {

    public static String stocksButtonString = "STOCK";
    public static JPanel stockPanel;

    public static JPanel getStocksPanel() {
        stockPanel = WestPanelController.getEachWestSubPanel();
        JLabel stockLabel = new JLabel(stocksButtonString, JLabel.CENTER);
        stockLabel.setFont(WestPanelController.panelLabelFonts);
        stockPanel.add(stockLabel);
        stockPanel.setBackground(WestPanelController.westPanelColor);
        stockPanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(stockPanel));
        stockPanel.addMouseListener(WestPanelController.getStockPanelAction());

        return stockPanel;
    }
}
