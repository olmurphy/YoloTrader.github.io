package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.WestPanelController;

import javax.swing.*;

public class Stock {

    public static String stockPanelLabel = "<html><span style=\"font-family:Futura;font-size:" +
            WestPanelController.size + "px;color:white;\"><B>STOCK</B>";
    public static JPanel stockPanel;

    public static JPanel getStocksPanel() { return stockPanel; }

    public static void setStockPanel() {
        stockPanel = WestPanelController.getEachWestSubPanel();
        JLabel stockLabel = new JLabel(stockPanelLabel, JLabel.CENTER);
        stockPanel.add(stockLabel);
        stockPanel.setBackground(WestPanelController.westPanelColor);
        stockPanel.addMouseListener(WestPanelController.getGeneralWestPanelActions(stockPanel, stockPanelLabel));
        stockPanel.addMouseListener(WestPanelController.getStockPanelAction(stockPanel, stockPanelLabel));
    }
}
