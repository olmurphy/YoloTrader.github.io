package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.stocks;

import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class StocksSection {

    public static JPanel stocksMainPanel;
    public static JPanel stockButtonPanel;

    public static Font stockButtonFont;
    public static Font stockLabelFont;

    public static JList watchListList;
    public static JList stockList;

    public static ListModel watchListModel; // need these
    public static ListModel stockListModel; // need these

    public static Border buttonBorder;

    public static JPanel getStocksMainPanel() {
        return stocksMainPanel;
    }

    public static void setStocksMainPanel() {
        stocksMainPanel = new JPanel(new BorderLayout());
        stockButtonFont = new Font("Sans-Serif", Font.PLAIN, 16);
        stockLabelFont = new Font("Sans-Serif", Font.PLAIN, 16);
        buttonBorder = BorderFactory.createEmptyBorder();
        stocksMainPanel.add(getStockButtonPanel(), BorderLayout.NORTH);
        stocksMainPanel.add(getStockListPanel(), BorderLayout.CENTER);
    }

    public static JPanel getStockButtonPanel() {

        stockButtonPanel = new JPanel();
        stockButtonPanel.setLayout(new GridLayout(1, 2));
        stockButtonPanel.add(getAddListButton());
        stockButtonPanel.add(getAddStockButton());

        return stockButtonPanel;
    }

    public static JButton getAddListButton() {
        JButton addListButton = new JButton("Add List");
        addListButton.setHorizontalAlignment(JButton.CENTER);

        addListButton.setFont(stockButtonFont);
        addListButton.setBackground(CenterPanelController.centerPanelColor);
        addListButton.setBorder(buttonBorder);
        addListButton.setOpaque(true);

        addListButton.addMouseListener(CenterPanelController.getGeneralStockButtonAction(addListButton));
        addListButton.addMouseListener(CenterPanelController.getAddWatchListButton());

        return addListButton;
    }

    public static JButton getAddStockButton() {
        JButton addStockButton = new JButton("Add Stock");
        addStockButton.setHorizontalAlignment(JButton.CENTER);

        addStockButton.setFont(stockButtonFont);
        addStockButton.setBackground(CenterPanelController.centerPanelColor);
        addStockButton.setBorder(buttonBorder);
        addStockButton.setOpaque(true);

        addStockButton.addMouseListener(CenterPanelController.getGeneralStockButtonAction(addStockButton));
        addStockButton.addMouseListener(CenterPanelController.getAddStockButtonAction());

        return  addStockButton;
    }

    public static JPanel getStockListPanel () {
        JPanel stockListPanel = new JPanel(new BorderLayout());

        stockListPanel.add(getStockListLabelPanel(), BorderLayout.NORTH);

        // FIXME: add the JList of watchList and stocks
        stockListPanel.add(getStockJListsPanel(), BorderLayout.CENTER);

        return stockListPanel;
    }

    public static JPanel getStockListLabelPanel() {
        JPanel stockListPanel = new JPanel();
        stockListPanel.setLayout(new GridLayout(1, 2));
        stockListPanel.add(getStockWatchListLabel());
        stockListPanel.add(getStocksLabel());
        stockListPanel.setBackground(CenterPanelController.centerPanelColor);

        return stockListPanel;
    }

    public static JLabel getStockWatchListLabel() {
        JLabel stockWatchListLabel = new JLabel("WatchLists", JLabel.CENTER);

        stockWatchListLabel.setFont(stockLabelFont);

        return stockWatchListLabel;
    }

    public static JLabel getStocksLabel() {
        JLabel stocksLabel = new JLabel("Stocks", JLabel.CENTER);

        stocksLabel.setFont(stockLabelFont);

        return stocksLabel;
    }

    public static JPanel getStockJListsPanel() {
        JPanel stockJListPanel = new JPanel();
        stockJListPanel.setLayout(new BoxLayout(stockJListPanel, BoxLayout.X_AXIS));

        stockJListPanel.add(getWatchListJListWithScrolling());
        stockJListPanel.add(getStockJListWithScrolling());

        return stockJListPanel;
    }

    public static JScrollPane getWatchListJListWithScrolling() {
        setWatchListModel(new DefaultListModel<String>());
        watchListList = new JList(getWatchListModel());

        return new JScrollPane(watchListList);
    }

    public static JScrollPane getStockJListWithScrolling() {

        setStockListModel(new DefaultListModel<String>());
        stockList = new JList(getStockListModel());

        return new JScrollPane(stockList);
    }

    public static void setStockListModel(ListModel stockListModel) {
        StocksSection.stockListModel = stockListModel;
    }

    public static ListModel getStockListModel() {
        return stockListModel;
    }

    public static void setWatchListModel(ListModel watchListModel) {
        StocksSection.watchListModel = watchListModel;
    }

    public static ListModel getWatchListModel() {
        return watchListModel;
    }

    public static JList getWatchListList() {
        return watchListList;
    }

    public static JList getStockList() {
        return stockList;
    }


}
