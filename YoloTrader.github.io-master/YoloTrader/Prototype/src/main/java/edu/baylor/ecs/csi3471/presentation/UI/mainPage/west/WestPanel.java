package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels.About;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels.Help;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels.Home;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels.Stock;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels.Profile;

import javax.swing.*;
import java.awt.*;

public class WestPanel {

    public static int westPanelWidth = 150;
    public static int westPanelHeight = MainPanel.frameHeight;
    public static JPanel westPanel;

    public static void creatWestPanel(JPanel mainPanel) {
        westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        WestPanelController.initializePublicStaticVariables();

        westPanel.setPreferredSize(new Dimension(westPanelWidth, westPanelHeight));
        westPanel.setBackground(WestPanelController.westPanelColor);

        westPanel.add(Home.getHomePanel());
        westPanel.add(Profile.getProfilePanel());
        westPanel.add(Stock.getStocksPanel());
        westPanel.add(Help.getHelpPanel());
        westPanel.add(About.getAboutPanel());

        mainPanel.add(westPanel, BorderLayout.WEST);
    }
}
