package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.subpanels.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WestPanelController {

    public static Border emptyBorder;
    public static Color active = Color.GRAY;
    public static Color westPanelColor = MainPanel.backGroundColor;
    public static int size = 14;

    public static String currPanel = "HOME";

    /**
     * initialize the look and feel of all JPanels in the ${@link WestPanel} area
     */
    public static void initializePublicStaticVariables() {
        emptyBorder = BorderFactory.createEmptyBorder();

        // setting home panel as initial panel
        MainPanel.getMainPanel().add(CenterPanelController.getHomePanel(), BorderLayout.CENTER);
        Home.getHomePanel().setBackground(active);
    }

    /**
     * sets the layout of the west panels to GridLayout of 1 row and 1 column
     * allows for local changes to be made and not have to individually change all panels
     * @return JPanel with the indicated layout
     */
    public static JPanel getEachWestSubPanel() { return new JPanel(new GridLayout(1,1)); }

    /**
     * This method is responsible for setting changing the colors of the west panel
     * options when the cursor is hovering over them
     * @param panel panel to set the background color of
     * @return MouseAdapter to listen for when the mouse enters or exits the panel
     */
    public static MouseAdapter getGeneralWestPanelActions(JPanel panel, String panelName) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!panelName.equals(currPanel)) { panel.setBackground(active); }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!panelName.equals(currPanel)) { panel.setBackground(westPanelColor); }
            }
        };
    }

    /**
     * sets the center in ${@link MainPanel} Center of BorderLayout to the Profile panel
     * @return MouseAdapter to listen for when the user clicks on the panel
     */
    public static MouseAdapter getProfilePanelAction(JPanel panel, String panelName) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                YoloTrader.logger.info("User clicks on profile panel");

                BorderLayout layout = (BorderLayout)MainPanel.getMainPanel().getLayout();

                try {
                    MainPanel.getMainPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException n) {
                    YoloTrader.logger.warning("NullPointerException raised");
                }

                MainPanel.getMainPanel().add(CenterPanelController.getProfilePanel(), BorderLayout.CENTER);
                resetAllPanelColors();
                panel.setBackground(active);
                MainPanel.getMainPanel().updateUI();
                currPanel = panelName;
            }
        };
    }

    /**
     * sets the center in ${@link MainPanel} Center of BorderLayout to the About panel
     * @return MouseAdapter to listen for when the user clicks on the panel
     */
    public static MouseAdapter getAboutPanelAction(JPanel panel, String panelName) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                YoloTrader.logger.info("User clicks on about panel");

                BorderLayout layout = (BorderLayout)MainPanel.getMainPanel().getLayout();

                try {
                    MainPanel.getMainPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException n) {
                    YoloTrader.logger.warning("NullPointerException raised");
                }

                MainPanel.getMainPanel().add(CenterPanelController.getAboutPanel(), BorderLayout.CENTER);
                resetAllPanelColors();
                panel.setBackground(active);
                MainPanel.getMainPanel().updateUI();
                currPanel = panelName;
            }
        };
    }

    /**
     * sets the center in ${@link MainPanel} Center of BorderLayout to the Help panel
     * @return MouseAdapter to listen for when the user clicks on the panel
     */
    public static MouseAdapter getHelpPanelAction(JPanel panel, String panelName) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                YoloTrader.logger.info("User clicks on help panel");

                BorderLayout layout = (BorderLayout)MainPanel.getMainPanel().getLayout();
                try {
                    MainPanel.getMainPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException n) {
                    YoloTrader.logger.warning("NullPointerException raised");
                }

                MainPanel.getMainPanel().add(CenterPanelController.getHelpPanel(), BorderLayout.CENTER);
                resetAllPanelColors();
                panel.setBackground(active);
                MainPanel.getMainPanel().updateUI();
                currPanel = panelName;
            }
        };
    }

    /**
     * sets the center in ${@link MainPanel} Center of BorderLayout to the Home panel
     * @return MouseAdapter to listen for when the user clicks on the panel
     */
    public static MouseAdapter getHomePanelAction(JPanel panel, String panelName) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                YoloTrader.logger.info("navigating to home panel");

                BorderLayout layout = (BorderLayout)MainPanel.getMainPanel().getLayout();
                try {
                    MainPanel.getMainPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException n) {
                    YoloTrader.logger.warning("NullPointerException raised");
                }
                MainPanel.getMainPanel().add(CenterPanelController.getHomePanel(), BorderLayout.CENTER);
                resetAllPanelColors();
                panel.setBackground(active);
                MainPanel.getMainPanel().updateUI();
                currPanel = panelName;
            }
        };
    }

    /**
     * sets the center in ${@link MainPanel} Center of BorderLayout to the Stock panel
     * @return MouseAdapter to listen for when the user clicks on the panel
     */
    public static MouseAdapter getStockPanelAction(JPanel panel, String panelName) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                YoloTrader.logger.info("User clicks on stock panel");

                BorderLayout layout = (BorderLayout)MainPanel.getMainPanel().getLayout();
                try {
                    MainPanel.getMainPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException n) {
                    YoloTrader.logger.warning("NullPointerException raised");
                }
                MainPanel.getMainPanel().add(CenterPanelController.getStockPanel(), BorderLayout.CENTER);
                resetAllPanelColors();
                panel.setBackground(active);
                MainPanel.getMainPanel().updateUI();
                currPanel = panelName;
            }
        };
    }

    public static void resetAllPanelColors() {
        Home.getHomePanel().setBackground(westPanelColor);
        Profile.getProfilePanel().setBackground(westPanelColor);
        Stock.getStocksPanel().setBackground(westPanelColor);
        Help.getHelpPanel().setBackground(westPanelColor);
        About.getAboutPanel().setBackground(westPanelColor);
    }

    public static void setAllPanels() {
        Home.setHomePanel();
        Profile.setProfilePanel();
        Stock.setStockPanel();
        Help.setHelpPanel();
        About.setAboutPanel();
    }
}
