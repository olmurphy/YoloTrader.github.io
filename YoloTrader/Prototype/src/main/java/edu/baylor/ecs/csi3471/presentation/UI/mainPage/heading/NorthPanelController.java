package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Name;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Search;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NorthPanelController {

    public static int northPanelWidth = MainPanel.frameWidth;
    public static int northPanelHeight = 120;
    public static Color northPanelColor = MainPanel.backGroundColor;

    public static ActionListener getSearchButtonAction(JTextField search) {
        return e -> {
            if (search.getText().equals("")) {
                Search.getSearchWarning();
            } else {
                YoloTrader.logger.info("Searching stock...");
            }
        };
    }

    public static void setName(String name) {
        Name.setName(name);
    }
}
