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

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

public class CenterPanelController {

    public static Color buttonColorActive = Color.GRAY;
    public static Color centerPanelColor = MainPanel.backGroundColor;

    public static int centerPanelHeight = MainPanel.frameHeight - NorthPanelController.northPanelHeight;


    public static JScrollPane getProfilePanel() { return ProfileSection.getProfilePanel(); }

    public static JPanel getStockPanel() { return StocksSection.getStocksMainPanel(); }

    public static JPanel getHelpPanel() { return HelpSection.getHelpPanel(); }

    public static void setAllCenterPanels() {
        AboutSection.setMainAboutPanel();
        HelpSection.setHelpPanel();
        ProfileSection.setProfilePanel();
        StocksSection.setStocksMainPanel();
    }

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

    public static MouseAdapter getAddStockButtonAction () {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // FIXME: add an action here
                // FIXME: need to add a disabled button action for when no watchlist is selected

                if (StocksSection.getWatchListList().isSelectionEmpty()) {
                    AddStock.getWarningMessage();
                } else {

                }

                YoloTrader.logger.info("user wants to add a stock");
            }
        };
    }

    public static MouseAdapter getAddWatchListButton() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // FIXME: add an action here
                YoloTrader.logger.info("adding stock list a watchlist");

                String watchListName = CreateWatchList.watchListNameWindow();
                StockWatchList stockWatchList = new StockWatchList(watchListName, new Date());

                if (MainPanel.getStockWatchListController().addWatchList(stockWatchList)) {
                    ((DefaultListModel<String>)StocksSection.watchListModel).addElement(stockWatchList.getName());
                } else {
                    CreateWatchList.getWatchListNameTaken();
                }
            }
        };
    }

    public static void  setAllFields() {
        Profile profile = MainPanelController.getProfileController().getProfile();

        ProfileSection.setFields(profile.getFirst(), profile.getLast(), profile.getUsername(), profile.getEmail());
        initializeModels(profile.getWatchLists());
    }

    public static void initializeModels(List<StockWatchList> watchListList) {

        for (int i = 0; i < watchListList.size(); i++) {
            ((DefaultListModel<String>)StocksSection.watchListModel).addElement(watchListList.get(i).getName());
        }
    }
}

