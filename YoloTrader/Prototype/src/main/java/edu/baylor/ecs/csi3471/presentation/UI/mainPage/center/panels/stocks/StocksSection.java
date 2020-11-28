package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author owenmurphy
 */
public class StocksSection {

    public static JPanel stocksMainPanel;
    public static JPanel stockButtonPanel;

    public static JList<String> watchListList;
    public static JList<String> stockList;

    public static ListModel<String> watchListModel; // need these
    public static ListModel<String> stockListModel; // need these

    /**
     * @return the stocks panel
     */
    public static JPanel getStocksMainPanel() {
        return stocksMainPanel;
    }

    public static void setStocksMainPanel(Profile profile) {
        stocksMainPanel = new JPanel(new BorderLayout());
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
        JButton addWatchListButton = new JButton(CenterPanelController.leftButtonSide + "Add List" +
                CenterPanelController.rightButtonSide);
        addWatchListButton.setHorizontalAlignment(JButton.CENTER);

        addWatchListButton.setBackground(CenterPanelController.centerPanelColor);
        addWatchListButton.setBorder(CenterPanelController.emptyButtonBorder);
        addWatchListButton.setOpaque(true);

        addWatchListButton.addMouseListener(CenterPanelController.getGeneralButtonAction(addWatchListButton));
        addWatchListButton.addMouseListener(CenterPanelController.getAddWatchListButton());

        return addWatchListButton;
    }

    public static JButton getDeleteWatchListButton() {
        JButton deleteWatchListButton = new JButton(CenterPanelController.leftButtonSide + "Delete List" +
                CenterPanelController.rightButtonSide);
        deleteWatchListButton.setHorizontalAlignment(JButton.CENTER);

        deleteWatchListButton.setBackground(CenterPanelController.centerPanelColor);
        deleteWatchListButton.setBorder(CenterPanelController.emptyButtonBorder);
        deleteWatchListButton.setOpaque(true);

        deleteWatchListButton.addMouseListener(CenterPanelController.getGeneralButtonAction(deleteWatchListButton));
        deleteWatchListButton.addMouseListener(CenterPanelController.getDeleteWatchListAction());

        return deleteWatchListButton;
    }

    public static JButton getAddStockButton() {
        JButton addStockButton = new JButton(CenterPanelController.leftButtonSide + "Add Stock" +
                CenterPanelController.rightButtonSide);
        addStockButton.setHorizontalAlignment(JButton.CENTER);

        addStockButton.setBackground(CenterPanelController.centerPanelColor);
        addStockButton.setBorder(CenterPanelController.emptyButtonBorder);
        addStockButton.setOpaque(true);

        addStockButton.addMouseListener(CenterPanelController.getGeneralButtonAction(addStockButton));
        addStockButton.addMouseListener(CenterPanelController.getAddStockButtonAction());

        return addStockButton;
    }

    public static JButton getDeleteStockButton() {
        JButton deleteStockButton = new JButton(CenterPanelController.leftButtonSide + "Delete Stock" +
                CenterPanelController.rightButtonSide);
        deleteStockButton.setHorizontalAlignment(JButton.CENTER);

        deleteStockButton.setBackground(CenterPanelController.centerPanelColor);
        deleteStockButton.setBorder(CenterPanelController.emptyButtonBorder);
        deleteStockButton.setOpaque(true);

        deleteStockButton.addMouseListener(CenterPanelController.getGeneralButtonAction(deleteStockButton));
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
        return new JLabel(CenterPanelController.leftLabelSide + "WATCHLIST" + CenterPanelController.rightLabelSide,
                JLabel.CENTER);
    }

    public static JLabel getStocksLabel() {
        return new JLabel(CenterPanelController.leftLabelSide + "STOCKS" + CenterPanelController.rightLabelSide,
                JLabel.CENTER);
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

        watchListList.addListSelectionListener(CenterPanelController.getWatchJListListener(watchListList));
        watchListList.addMouseListener(CenterPanelController.getWatchListRightClickMouseAction(watchListList));

        return new JScrollPane(watchListList);
    }

    public static JScrollPane getStockJListWithScrolling() {
        setStockListModel(new DefaultListModel<>());
        stockList = new JList<>(getStockListModel());

        stockList.addMouseListener(CenterPanelController.getStockListRightClickMouseAction(stockList));

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
        for (StockWatchList stockWatchList : list) {
            ((DefaultListModel<String>) watchListModel).addElement(stockWatchList.getName());
        }
    }

    /**
     * @return menu with item menus 'open' and 'remove' for a watch list
     */
    public static JPopupMenu getWatchListPopupMenu() {
        JPopupMenu menu = new JPopupMenu();

        // setting the buttons
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemRemove = new JMenuItem("Delete");
        JMenuItem itemRename = new JMenuItem("Rename");

        // adding the listeners
        itemOpen.addActionListener(CenterPanelController.getWatchListOpenItemListener());
        itemRemove.addActionListener(CenterPanelController.getWatchListRemoveItemListener());
        itemRename.addActionListener(CenterPanelController.getWatchListRenameItemListener());

        // add the buttons
        menu.add(itemOpen);
        menu.add(itemRemove);
        menu.add(itemRename);

        return menu;
    }

    /**
     * @return menu with item menus 'open' and 'remove' for a stock item
     */
    public static JPopupMenu getStockListPopupMenu() {
        JPopupMenu menu = new JPopupMenu();

        // setting the buttons
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemRemove = new JMenuItem("Delete");

        // adding the listeners
        itemOpen.addActionListener(CenterPanelController.getStockListOpenItemListener());
        itemRemove.addActionListener(CenterPanelController.getStockListRemoveItemListener());

        // add the buttons
        menu.add(itemOpen);
        menu.add(itemRemove);

        return menu;
    }
}
