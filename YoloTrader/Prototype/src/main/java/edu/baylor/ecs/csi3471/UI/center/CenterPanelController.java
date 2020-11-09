package edu.baylor.ecs.csi3471.UI.center;

import edu.baylor.ecs.csi3471.UI.MainPanel;
import edu.baylor.ecs.csi3471.UI.center.profile.ProfileSection;
import edu.baylor.ecs.csi3471.UI.center.stocks.StocksSection;
import edu.baylor.ecs.csi3471.UI.heading.NorthPanelController;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CenterPanelController {

    public static Color buttonColorActive = Color.GRAY;
    public static Color centerPanelColor = MainPanel.backGroundColor;


    public static int centerPanelHeight = MainPanel.frameHeight - NorthPanelController.northPanelHeight;

    public static JScrollPane getProfilePanel() { return ProfileSection.getProfilePanel(); }

    public static JPanel getStockPanel() { return StocksSection.getStocksMainPanel(); }

    public static MouseAdapter getGeneralStockButtonAction(JButton button) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                YoloTrader.logger.info("mouse entered stock button");
                button.setBackground(buttonColorActive);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                YoloTrader.logger.info("mouse exited stock button");
                button.setBackground(centerPanelColor);
                super.mouseExited(e);
            }
        };
    }

    public static MouseAdapter getAddStockButtonAction () {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // FIXME: add an action here
                // FIXME: need to add a disabled button action for when no watchlist is selected
                YoloTrader.logger.info("user wants to add a stock");
            }
        };
    }

    public static MouseAdapter getAddWatchListButton() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // FIXME: add an action here
                YoloTrader.logger.info("user wants to add a watchlist");
            }
        };
    }

}
