package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.about.AboutSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.help.HelpSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.profile.ProfileSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.stocks.AddStock;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.stocks.CreateWatchList;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.stocks.StocksSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.StockWatchListController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

/**
 * @author owenmurphy
 */
public class CenterPanelController {

    public static Color buttonColorActive = Color.GRAY;
    public static Color centerPanelColor = MainPanel.backGroundColor;

    public static int centerPanelHeight = MainPanel.frameHeight - NorthPanelController.northPanelHeight;

    public static StockWatchListController stockWatchListController;

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
                YoloTrader.logger.info("deleting stock");
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
                StockWatchList stockWatchList = new StockWatchList(watchListName, new Date());

                // MainPanelController.getProfileController()
                stockWatchListController.addWatchList(stockWatchList);
                // MainPanelController.getProfileController().getProfile().getWatchLists().add(stockWatchList);
                ((DefaultListModel<String>)StocksSection.watchListModel).addElement(stockWatchList.getName());

                MainPanelController.getProfileController().save();

                //MainPanelController


                /*if (stockWatchListController.addWatchList(stockWatchList)) {
                    ((DefaultListModel<String>)StocksSection.watchListModel).addElement(stockWatchList.getName());

                    MainPanelController.getProfileController().getProfile().setWatchLists(stockWatchListController.getService().getDao().getAllWatchLists());

                } else {
                    CreateWatchList.getWatchListNameTaken();
                }*/
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
                    String listName = StocksSection.getWatchListList().getSelectedValue().toString();

                    System.out.println("trying to delete: " + listName);
                    if (stockWatchListController.removeWatchList(listName)) {
                        ((DefaultListModel)StocksSection.watchListModel).removeElement(listName);
                        YoloTrader.logger.info("deleting watchList");
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

        stockWatchListController = new StockWatchListController();
        stockWatchListController.loadStockLists(profile.getWatchLists());
        stockWatchListController.getService().getDao().getAll().forEach(System.out::println);
    }

    /**
     * @return the stock watchList controller of the user's stocks
     */
    public static StockWatchListController getStockWatchListController() {
        return stockWatchListController;
    }
}

