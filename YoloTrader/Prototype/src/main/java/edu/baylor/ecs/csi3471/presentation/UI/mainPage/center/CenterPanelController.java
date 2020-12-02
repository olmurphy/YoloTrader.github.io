package edu.baylor.ecs.csi3471.presentation.ui.mainPage.center;

import edu.baylor.ecs.csi3471.model.Comment;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.MainPanelController;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.panels.*;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.pages.*;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.swing.*;
import javax.swing.border.Border;
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

    public static Color centerPanelColor = MainPanel.backGroundColor;

    public static int centerPanelHeight = MainPanel.frameHeight - NorthPanelController.northPanelHeight;

    public static Border emptyButtonBorder = BorderFactory.createEmptyBorder();
    public static Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE);

    public static String leftLabelSide = "<html><span style=\"font-family:Futura;color:white;font-size:14px;\">";
    public static String rightLabelSide = "</span></html>";

    public static String leftButtonSide = "<html><span style=\\\"font-family:Futura;color:white;font-size:14px;\">";
    public static String rightButtonSide = "</span></html>";

    public static JScrollPane getHomePanel(){ return HomeSection.getHomeMainPanel(); }

    public static JScrollPane getProfilePanel() { return ProfileSection.getProfilePanel(); }

    public static JPanel getStockPanel() { return StocksSection.getStocksMainPanel(); }

    public static JPanel getHelpPanel() { return HelpSection.getHelpPanel(); }

    public static JPanel getAboutPanel() { return AboutSection.getMainAboutPanel(); }

    public static MouseAdapter getGeneralButtonAction(JButton button) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { button.setBorder(whiteBorder); }

            @Override
            public void mouseExited(MouseEvent e) { button.setBorder(emptyButtonBorder); }
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
                // check if stock watch list selected
                if (StocksSection.getWatchListList().isSelectionEmpty()) { Dialogs.getNoWatchListSelectedWarning(); }
                else {
                    YoloTrader.logger.info("adding stock");
                    String stockName = Dialogs.getAddStockInputDialog();

                    // trying to add a single stock, else display the result from query using dialog from Result class
                    NorthPanelController.launchSearch(stockName, true);
                }
            }
        };
    }

    /**
     * calls ${@link #deleteStockFromList()} to delete a stock from a watchlist of user's specified watch list
     * @return MouseAdapter to listen for when the button is clicked
     */
    public static MouseAdapter getDeleteStockButtonAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // check if watch list is clicked
                if (StocksSection.getStockList().isSelectionEmpty()) { Dialogs.getNoStockSelectedWarning(); }
                else { deleteStockFromList(); }
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
                String watchListName = Dialogs.watchListNameWindow();

                StockWatchList stockWatchList = null;
                boolean nameEmpty = false;

                if (watchListName == null || watchListName.equals("")) { nameEmpty = true; }
                else { stockWatchList = new StockWatchList(watchListName, new Date()); }

                if (!nameEmpty && MainPanelController.stockWatchListController.addWatchList(stockWatchList)) {
                    ((DefaultListModel<String>)StocksSection.watchListModel).addElement(stockWatchList.getName());

                    MainPanelController.getProfileController().saveProfiles(); // saving to database
                } else { Dialogs.getWatchListNameTaken(); }
            }
        };
    }

    /**
     * calls ${@link #deleteWatchList()} for deleting a watchlist from a user's profile
     * @return MouseAdapter to listen for when the button is clicked
     */
    public static MouseAdapter getDeleteWatchListAction() {
        return  new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // check that a watch list is selected
                if (StocksSection.getWatchListList().isSelectionEmpty()) { Dialogs.getNoWatchListSelectedWarning(); }
                else { deleteWatchList(); }
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

                    for (Stock stock : stockList) { ((DefaultListModel<String>) StocksSection.getStockListModel()).addElement(stock.getName()); }
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
                    list.setSelectedIndex(list.locationToIndex(e.getPoint())); // set the index of the item that was clicked

                    JPopupMenu menu = StocksSection.getWatchListPopupMenu(); // get the menu item

                    menu.show(list, e.getPoint().x, e.getPoint().y); // show the menu
                }
            }
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
                    list.setSelectedIndex(list.locationToIndex(e.getPoint())); // set the index of the item that was clicked

                    JPopupMenu menu = StocksSection.getStockListPopupMenu(); // get the menu item

                    menu.show(list, e.getPoint().x, e.getPoint().y); // show the menu
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

            for (Stock stock : list) { ((DefaultListModel<String>) StocksSection.getStockListModel()).addElement(stock.getName()); }
        }
    }

    /**
     * this class is introduced to promote low coupling between classes
     * @return JList of the watch list
     */
    public static JList<String> getWatchListJList() { return StocksSection.getWatchListList(); }

    /**
     * sets the action for the delete account button
     * @return ActionListener to listen for when the delete account button is pressed
     */
    public static ActionListener getDeleteAccountListener() {
        return e -> {
            String pass = Dialogs.getPassWordDialog();

            if (pass != null && !pass.equals("")) {

                if (MainPanelController.getProfileController().deleteProfile(pass)) {
                    MainPanelController.getProfileController().saveProfiles();

                    MainPanel.getHomeFrame().dispose();
                    MainPanel.getStartFrame();
                } else { Dialogs.getPasswordNotCorrectWarning(); }
            }
        };
    }

    /**
     * sets the action for the change password button action
     * @return ActionListener to listen for when the button is pressed
     */
    public static ActionListener getChangePasswordListener() { return e -> Dialogs.getChangePassDialog(); }

    /**
     * when the open button is clicked the information for a watch list opens
     * @return ActionListener will perform action when the open button is clicked on watch list
     */
    public static ActionListener getWatchListOpenItemListener() { return e -> { }; }

    /**
     * when the remove button is clicked it calls ${@link #deleteWatchList()} to delete the
     * selected watch list from the user's profile
     * @return ActionListener will perform action when the remove button is clicked on watch list
     */
    public static ActionListener getWatchListRemoveItemListener() { return e -> deleteWatchList(); }

    /**
     * method calls ${@link Dialogs#watchListNameWindow()} to retrieve user's desire name
     * for watch list. if name is not empty, it calls
     * ${@link edu.baylor.ecs.csi3471.presentation.presentationLogic.StockWatchListController#renameStockWatchList(String, String)}
     * to rename the watch list to a new name
     * @return ActionListener to list for a the mouse to press
     */
    public static ActionListener getWatchListRenameItemListener() {
        return e -> {
            String oldName = StocksSection.getWatchListList().getSelectedValue();
            String newName = Dialogs.watchListNameWindow();

            if (!newName.equals("")) {
                MainPanelController.getStockWatchListController().renameStockWatchList(newName, oldName);

                MainPanelController.getProfileController().saveProfiles(); // saving profiles to database

                // updating the watch list names
                ((DefaultListModel<String>)StocksSection.getWatchListModel()).removeElement(oldName);
                ((DefaultListModel<String>)StocksSection.getWatchListModel()).addElement(newName);
            }
        };
    }

    /**
     * when the open button is clicked the information for a stock  opens
     * @return ActionListener will perform action when the open button is clicked on stock
     */
    public static ActionListener getStockListOpenItemListener() {
        return e -> {
            String stockName = StocksSection.getStockList().getSelectedValue();
            String listName = StocksSection.getWatchListList().getSelectedValue();

            StockWatchList list = MainPanelController.stockWatchListController.findStockWatchList(listName);
            Stock stock = MainPanelController.getStockController().findStock(stockName, list);

            StockPage.addStockToPanel(stock);
        };
    }

    /**
     * when the remove button is clicked it calls ${@link #deleteStockFromList()} to
     * delete the stock from the list
     * @return ActionListener will perform action when the remove button is clicked on stock
     */
    public static ActionListener getStockListRemoveItemListener() { return e -> deleteStockFromList(); }

    /**
     * the method deletes a watch list from the user's profile.
     * This method was introduced to avoid duplication for deleting a watch list
     * @return true if watch list was deleted, else false
     */
    public static boolean deleteWatchList() {
        String listName = StocksSection.getWatchListList().getSelectedValue();

        if (MainPanelController.stockWatchListController.removeWatchList(listName)) {
            ((DefaultListModel<String>)StocksSection.watchListModel).removeElement(listName);
            YoloTrader.logger.info("deleting watchList");

            MainPanelController.getProfileController().saveProfiles(); // saving changes database

            return true;
        }
        return  false;
    }

    /**
     * the method deletes a stock list from the user's watch list selected
     * This method was introduced to avoid duplication for deleting a stock from stock list
     * @return true if stock was deleted, else false
     */
    public static boolean deleteStockFromList() {
        String listName = StocksSection.getWatchListList().getSelectedValue();  // get selected watchlist name
        String stockName = StocksSection.getStockList().getSelectedValue();     // get selected stock name

        StockWatchList watchList = MainPanelController.stockWatchListController.findStockWatchList(listName); // find watch list

        if(MainPanelController.getStockController().removeStock(stockName, watchList)) { // check if the stock was removed

            ((DefaultListModel<String>)StocksSection.getStockListModel()).removeElement(stockName); // delete from JList UI

            YoloTrader.logger.info("stock deleted..."); // log message

            MainPanelController.getProfileController().saveProfiles(); // save to database

            return true;
        }
        return false;
    }

    public static ActionListener getEditProfileListener() { return e -> Dialogs.getEditProfileDialog(); }

    public static ActionListener getEditCommentButtonAction(Comment comment) { return e -> { }; }

    public static ActionListener getAddCommentButtonAction() { return e -> System.out.println("adding comment to stock"); }

    public static ActionListener getSaveCommentButtonAction() { return e -> { }; }

    public static ActionListener getDeleteCommentButtonAction() { return e -> { }; }
}