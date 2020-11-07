package edu.baylor.ecs.csi3471.UI.west.stocks;

import edu.baylor.ecs.csi3471.UI.west.WestPanelUtility;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Stock {

    public static String stocksButtonString = "STOCK";
    public static JPanel stockPanel;

    public static JPanel getStocksPanel() {
        stockPanel = WestPanelUtility.getEachWestSubPanel();
        JLabel stockLabel = new JLabel(stocksButtonString, JLabel.CENTER);
        stockLabel.setFont(WestPanelUtility.panelLabelFonts);
        stockPanel.add(stockLabel);
        stockPanel.setBackground(WestPanelUtility.westPanelColor);
        stockPanel.addMouseListener(WestPanelUtility.getGeneralWestPanelActions(stockPanel));
        stockPanel.addMouseListener(getStockPanelAction());

        return stockPanel;
    }

    public static MouseAdapter getStockPanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // FIXME: add action here
                System.out.println("clicked");
            }
        };
    }
}
