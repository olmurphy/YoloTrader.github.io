package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.AboutSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.HelpSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.HomeSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.ProfileSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks.AddStock;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks.CreateWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks.StocksSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.StockWatchListController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

/**
 * @author owenmurphy
 */
public class CenterPanelController {

    public static Color buttonColorActive = Color.GRAY;
    public static Color centerPanelColor = MainPanel.backGroundColor;

    public static int centerPanelHeight = MainPanel.frameHeight - NorthPanelController.northPanelHeight;

    // FIXME: may need to return a JScrollPane depending on what is added in the home panel
    public static JPanel getHomePanel(){ return HomeSection.getHomeMainPanel(); }

    public static JScrollPane getProfilePanel() { return ProfileSection.getProfilePanel(); }

    public static JPanel getStockPanel() { return StocksSection.getStocksMainPanel(); }

    public static JPanel getHelpPanel() { return HelpSection.getHelpPanel(); }

    public static JPanel getAboutPanel() { return AboutSection.getMainAboutPanel(); }

    public static MouseAdapter getGeneralStockButtonAction(JButton button) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(buttonColorActive);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(centerPanelColor);
            }
        };
    }

    /**
     * logic for adding a stock to a watch list of a user's watch list
     * @return MouseAdapter to listen for when the button is clicked
     */
    public static MouseAdapter getAddStockButtonAction () {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                YoloTrader.logger.info("user wants to add a stock");

                if (StocksSection.getWatchListList().isSelectionEmpty()) {
                    // no watchlist selected
                    AddStock.getNoWatchListSelectedWarning();
                } else {
                    String stockName = AddStock.getAddStockInputDialog();

                    // trying to add a single stock, else display the result from query using dialog from Result class
                    NorthPanelController.launchSearch(stockName, true);
                }

            }
        };
    }

    /**
     * logic for deleting a stock from a watchlist of user's specified watch list
     * @return MouseAdapter to listen for when the button is clicked
     */
    public static MouseAdapter getDeleteStockButtonAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (StocksSection.getStockList().isSelectionEmpty()) {
                    // no stock selected
                    AddStock.getNoStockSelectedWarning();
                } else {

                    String listName = StocksSection.getWatchListList().getSelectedValue();
                    String stockName = StocksSection.getStockList().getSelectedValue();

                    StockWatchList watchList = MainPanelController.stockWatchListController.findStockWatchList(listName);
                    if(MainPanelController.getStockController().removeStock(stockName, watchList)) {

                        ((DefaultListModel<String>)StocksSection.getStockListModel()).removeElement(stockName);

                        YoloTrader.logger.info("stock deleted...");

                        MainPanelController.getProfileController().saveProfiles();
                    }
                }

            }
        };
    }

    /**
     * logic for adding a watch list to user's watch list
     * @return MouseAdapter to listen for when the button is clicked
     */
    public static MouseAdapter getAddWatchListButton() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                YoloTrader.logger.info("adding stock list a watchlist");

                String watchListName = CreateWatchList.watchListNameWindow();

                StockWatchList stockWatchList = null;
                boolean nameEmpty = false;
                if (watchListName.equals("")) {
                    nameEmpty = true;
                } else {
                    stockWatchList = new StockWatchList(watchListName, new Date());
                }

                if (!nameEmpty && MainPanelController.stockWatchListController.addWatchList(stockWatchList)) {
                    ((DefaultListModel<String>)StocksSection.watchListModel).addElement(stockWatchList.getName());

                    // saving changes to xml file
                    MainPanelController.getProfileController().saveProfiles();
                } else {
                    CreateWatchList.getWatchListNameTaken();
                }
            }
        };
    }

    /**
     * logic for deleting a watchlist from a user's profile
     * @return MouseAdapter to listen for when the button is clicked
     */
    public static MouseAdapter getDeleteWatchListAction() {
        return  new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (StocksSection.getWatchListList().isSelectionEmpty()) {
                    // no watchlist selected
                    AddStock.getNoWatchListSelectedWarning();
                } else {
                    String listName = StocksSection.getWatchListList().getSelectedValue();

                    if (MainPanelController.stockWatchListController.removeWatchList(listName)) {
                        ((DefaultListModel<String>)StocksSection.watchListModel).removeElement(listName);
                        YoloTrader.logger.info("deleting watchList");

                        // saving changes to xml file
                        MainPanelController.getProfileController().saveProfiles();
                    }
                }
            }
        };
    }

    /**
     * calls all the panels in the center panel of ${@link MainPanel}
     * to set their fields accordingly. In addition, it initializes and load watch list controller
     * @param profile user's profile to the necessary fields ot set the panel fields
     */
    public static void setAllCenterPanels(Profile profile) {
        AboutSection.setMainAboutPanel();
        HelpSection.setHelpPanel();
        ProfileSection.setProfilePanel(profile);
        StocksSection.setStocksMainPanel(profile);
        HomeSection.setHomeMainPanel();

        MainPanelController.stockWatchListController = new StockWatchListController();
        MainPanelController.stockWatchListController.loadStockLists(profile.getWatchLists());
    }

    /**
     * listens for a change in the selected watch list and displays the stocks in the watch list on the second
     * JList in the Stock Panel
     * @param list JList to listen for a change to
     * @return ListSelectionListener to listen for when a selected item in a list has changed
     */
    public static ListSelectionListener getWatchJListListener(JList<String> list) {
        return e -> {
            if (!e.getValueIsAdjusting()) {
                ((DefaultListModel<String>)StocksSection.getStockListModel()).removeAllElements();
                String watchListName = list.getSelectedValue();

                StockWatchList watchList = MainPanelController.getStockWatchListController().findStockWatchList(watchListName);
                if (watchList != null) {
                    List<Stock> stockList = watchList.getStockList();
                    for (Stock stock : stockList) {
                        ((DefaultListModel<String>) StocksSection.getStockListModel()).addElement(stock.getName());
                    }
                }
            }
        };
    }

    /**
     * this adds the functionality of the user right clicks an item in the watch list JList and it opens up a menu
     * @return MouseAdapter that listens for a rick click button
     */
    public static MouseAdapter getWatchListRightClickMouseAction(JList<String> list) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {

                    // set the index of the item that was clicked
                    list.setSelectedIndex(list.locationToIndex(e.getPoint()));

                    // get the menu item
                    JPopupMenu menu = StocksSection.getWatchListPopupMenu();

                    // show the menu
                    menu.show(list, e.getPoint().x, e.getPoint().y);

                    System.out.println("index: " + list.getSelectedIndex());
                }
            }
            /*
                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem itemRemove = new JMenuItem("Remove");
                    itemRemove.addActionListener(e1 -> {
                        System.out.println("Remove the element in position " + listbox.getSelectedValue());

                    });
                    menu.add(itemRemove);
                    menu.show(listbox, e.getPoint().x, e.getPoint().y);
                }
             */
        };
    }

    /**
     * this adds the functionality of the user right clicks an item in the stock list JList and it opens up a menu
     * @return MouseAdapter that listens for a rick click button
     */
    public static MouseAdapter getStockListRightClickMouseAction(JList<String> list) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {

                    // set the index of the item that was clicked
                    list.setSelectedIndex(list.locationToIndex(e.getPoint()));

                    // get the menu item
                    JPopupMenu menu = StocksSection.getStockListPopupMenu();

                    // show the menu
                    menu.show(list, e.getPoint().x, e.getPoint().y);

                    System.out.println("index: " + list.getSelectedIndex());
                }
            }
        };
    }

    /**
     * method is responsible for updating the stock list
     *
     * - if a watch list is selected and a stock was added or deleted, then this method is called to update the stock list
     */
    public static void updateStockListModel() {
        if (!StocksSection.getWatchListList().isSelectionEmpty()) {
            ((DefaultListModel<String>)StocksSection.getStockListModel()).removeAllElements();
            List<Stock> list = MainPanelController.getStockWatchListController().findStockWatchList(StocksSection.getWatchListList().getSelectedValue()).getStockList();
            for (Stock stock : list) {
                ((DefaultListModel<String>) StocksSection.getStockListModel()).addElement(stock.getName());
            }
        }
    }

    /**
     * this class is introduced to promote low coupling between classes
     * @return JList of the watch list
     */
    public static JList<String> getWatchListJList() {
        return StocksSection.getWatchListList();
    }

    /**
     * sets the action for the delete account button
     * @return ActionListener to listen for when the delete account button is pressed
     */
    public static ActionListener getDeleteAccountListener() {
        return e -> {
            String pass = ProfileSection.getPassWordDialog();
            if (MainPanelController.getProfileController().deleteAccount(pass)) {

                MainPanelController.getProfileController().saveProfiles();

                MainPanel.getHomeFrame().dispose();
                MainPanel.getStartFrame();
            } else {
                ProfileSection.getPasswordNotCorrectWarning();
            }
        };
    }

    /**
     * when the open button is clicked the information for a watch list opens
     * @return ActionListener will perform action when the open button is clicked on watch list
     */
    public static ActionListener getWatchListOpenItemListener() {
        return e -> {

        };
    }

    /**
     * when the remove button is clicked the watch list is removed
     * @return ActionListener will perform action when the remove button is clicked on watch list
     */
    public static ActionListener getWatchListRemoveItemListener() {
        return e -> {

        };
    }

    /**
     * when the open button is clicked the information for a stock  opens
     * @return ActionListener will perform action when the open button is clicked on stock
     */
    public static ActionListener getStockListOpenItemListener() {
        return e -> {

        };
    }

    /**
     * when the remove button is clicked the stock list is removed
     * @return ActionListener will perform action when the remove button is clicked on stock
     */
    public static ActionListener getStockListRemoveItemListener() {
        return e -> {

        };
    }
}

