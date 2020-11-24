package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

/**
 * @author owenmurphy
 */
public class StocksSection {

    private static JButton addStockButton;
    private static JButton addWatchListButton;
    private static JButton deleteWatchListButton;
    private static JButton deleteStockButton;

    public static JPanel stocksMainPanel;
    public static JPanel stockButtonPanel;

    public static Font stockButtonFont;
    public static Font stockLabelFont;

    public static JList<String> watchListList;
    public static JList<String> stockList;

    public static ListModel<String> watchListModel; // need these
    public static ListModel<String> stockListModel; // need these

    public static Border buttonBorder;

    /**
     * @return the stocks panel
     */
    public static JPanel getStocksMainPanel() {
        return stocksMainPanel;
    }

    public static void setStocksMainPanel(Profile profile) {
        stocksMainPanel = new JPanel(new BorderLayout());
        stockButtonFont = new Font("Sans-Serif", Font.PLAIN, 16);
        stockLabelFont = new Font("Sans-Serif", Font.PLAIN, 16);
        buttonBorder = BorderFactory.createEmptyBorder();
        stocksMainPanel.add(getStockButtonPanel(), BorderLayout.NORTH);
        stocksMainPanel.add(getStockListPanel(), BorderLayout.CENTER);

        initializeWatchListModel(profile); // initialize the JList model
    }

    public static JPanel getStockButtonPanel() {

        stockButtonPanel = new JPanel();
        stockButtonPanel.setLayout(new GridLayout(2, 2));

        // adding the 'add' buttons
        stockButtonPanel.add(getAddWatchListButton());
        stockButtonPanel.add(getAddStockButton());

        // adding the 'delete' buttons
        stockButtonPanel.add(getDeleteWatchListButton());
        stockButtonPanel.add(getDeleteStockButton());

        return stockButtonPanel;
    }

    /**
     * button for the add a list with the list name button to the user's watch lists
     * @return JButton
     */
    public static JButton getAddWatchListButton() {
        addWatchListButton = new JButton("Add List");
        addWatchListButton.setHorizontalAlignment(JButton.CENTER);

        addWatchListButton.setFont(stockButtonFont);
        addWatchListButton.setBackground(CenterPanelController.centerPanelColor);
        addWatchListButton.setBorder(buttonBorder);
        addWatchListButton.setOpaque(true);

        addWatchListButton.addMouseListener(CenterPanelController.getGeneralStockButtonAction(addWatchListButton));
        addWatchListButton.addMouseListener(CenterPanelController.getAddWatchListButton());

        return addWatchListButton;
    }

    public static JButton getDeleteWatchListButton() {
        deleteWatchListButton = new JButton("Delete List");
        deleteWatchListButton.setHorizontalAlignment(JButton.CENTER);

        deleteWatchListButton.setFont(stockButtonFont);
        deleteWatchListButton.setBackground(CenterPanelController.centerPanelColor);
        deleteWatchListButton.setBorder(buttonBorder);
        deleteWatchListButton.setOpaque(true);

        deleteWatchListButton.addMouseListener(CenterPanelController.getGeneralStockButtonAction(deleteWatchListButton));
        deleteWatchListButton.addMouseListener(CenterPanelController.getDeleteWatchListAction());

        return deleteWatchListButton;
    }

    public static JButton getAddStockButton() {
        addStockButton = new JButton("Add Stock");
        addStockButton.setHorizontalAlignment(JButton.CENTER);

        addStockButton.setFont(stockButtonFont);
        addStockButton.setBackground(CenterPanelController.centerPanelColor);
        addStockButton.setBorder(buttonBorder);
        addStockButton.setOpaque(true);

        addStockButton.addMouseListener(CenterPanelController.getGeneralStockButtonAction(addStockButton));
        addStockButton.addMouseListener(CenterPanelController.getAddStockButtonAction());

        return  addStockButton;
    }

    public static JButton getDeleteStockButton() {
        deleteStockButton = new JButton("Delete Stock");
        deleteStockButton.setHorizontalAlignment(JButton.CENTER);

        deleteStockButton.setFont(stockButtonFont);
        deleteStockButton.setBackground(CenterPanelController.centerPanelColor);
        deleteStockButton.setBorder(buttonBorder);
        deleteStockButton.setOpaque(true);

        deleteStockButton.addMouseListener(CenterPanelController.getGeneralStockButtonAction(deleteStockButton));
        deleteStockButton.addMouseListener(CenterPanelController.getDeleteStockButtonAction());

        return deleteStockButton;
    }

    public static JPanel getStockListPanel () {
        JPanel stockListPanel = new JPanel(new BorderLayout());

        stockListPanel.add(getStockListLabelPanel(), BorderLayout.NORTH);

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
        stockJListPanel.setLayout(new GridLayout(1, 2));

        stockJListPanel.add(getWatchListJListWithScrolling());
        stockJListPanel.add(getStockJListWithScrolling());

        return stockJListPanel;
    }

    public static JScrollPane getWatchListJListWithScrolling() {
        setWatchListModel(new DefaultListModel<>());
        watchListList = new JList<>(getWatchListModel());

        // FIXME: add listener
        watchListList.addListSelectionListener(CenterPanelController.getWatchJListListener(watchListList));

        return new JScrollPane(watchListList);
    }

    public static JScrollPane getStockJListWithScrolling() {
        setStockListModel(new DefaultListModel<>());
        stockList = new JList<>(getStockListModel());

        return new JScrollPane(stockList);
    }

    public static void setStockListModel(ListModel<String> stockListModel) {
        StocksSection.stockListModel = stockListModel;
    }

    public static ListModel<String> getStockListModel() {
        return stockListModel;
    }

    public static void setWatchListModel(ListModel<String> watchListModel) {
        StocksSection.watchListModel = watchListModel;
    }

    public static ListModel<String> getWatchListModel() {
        return watchListModel;
    }

    public static JList<String> getWatchListList() {
        return watchListList;
    }

    public static JList<String> getStockList() {
        return stockList;
    }

    /**
     * initializes the user's stock watch lists in the JList on the main frame when they login
     * @param profile user's profile that contains the watchlist
     */
    public static void initializeWatchListModel(Profile profile) {
        // get the profiles watch lists
        List<StockWatchList> list = profile.getWatchLists();

        // add watch lists to the JList
        for (int i = 0; i < list.size(); i++) {
            ((DefaultListModel<String>)watchListModel).addElement(list.get(i).getName());
        }
    }
}
