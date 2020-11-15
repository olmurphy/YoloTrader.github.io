package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WestPanelController {

    public static Border emptyBorder;
    public static Font panelLabelFonts;
    public static Color active = Color.GRAY;
    public static Color westPanelColor = MainPanel.backGroundColor;

    public static void initializePublicStaticVariables() {
        panelLabelFonts = new Font("Serif", Font.PLAIN, 18);
        emptyBorder = BorderFactory.createEmptyBorder();
    }

    public static JPanel getEachWestSubPanel() { return new JPanel(new GridLayout(1,1)); }

    public static MouseAdapter getGeneralWestPanelActions(JPanel panel) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(active);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(westPanelColor);
            }
        };
    }

    public static MouseAdapter getProfilePanelAction() {
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
                MainPanel.getMainPanel().updateUI();
            }
        };
    }

    public static MouseAdapter getAboutPanelAction() {
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
                MainPanel.getMainPanel().updateUI();
            }
        };
    }

    public static MouseAdapter getHelpPanelAction() {
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
                MainPanel.getMainPanel().updateUI();
            }
        };
    }

    public static MouseAdapter getHomePanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                // FIXME: perform action here
            }
        };
    }

    public static MouseAdapter getStockPanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // FIXME: add action here
                YoloTrader.logger.info("User clicks on stock panel");



                BorderLayout layout = (BorderLayout)MainPanel.getMainPanel().getLayout();
                try {
                    MainPanel.getMainPanel().remove(layout.getLayoutComponent(BorderLayout.CENTER));
                } catch (NullPointerException n) {
                    YoloTrader.logger.warning("NullPointerException raised");
                }
                MainPanel.getMainPanel().add(CenterPanelController.getStockPanel(), BorderLayout.CENTER);
                MainPanel.getMainPanel().updateUI();

            }
        };
    }
}
