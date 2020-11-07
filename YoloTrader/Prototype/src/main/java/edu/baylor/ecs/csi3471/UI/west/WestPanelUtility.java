package edu.baylor.ecs.csi3471.UI.west;

import edu.baylor.ecs.csi3471.UI.MainPanel;
import edu.baylor.ecs.csi3471.UI.center.CenterPanelUtility;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WestPanelUtility {

    public static Border emptyBorder;
    public static Font panelLabelFonts;
    public static Color active = Color.GRAY;
    public static Color westPanelColor = Color.lightGray;

    public static void initializePublicStaticVariables() {
        panelLabelFonts = new Font("Serif", Font.PLAIN, 18);
        emptyBorder = BorderFactory.createEmptyBorder();
    }

    public static JPanel getEachWestSubPanel() {
        return new JPanel(new GridLayout(1,1));
    }

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
                // FIXME: add cool effects

                MainPanel.getMainPanel().add(CenterPanelUtility.getProfilePanel(), BorderLayout.CENTER);
                MainPanel.getMainPanel().updateUI();
            }
        };
    }

    public static MouseAdapter getAboutPanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                // FIXME: add cool effects
            }
        };
    }

    public static MouseAdapter getHelpPanelAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked");
                // FIXME: add cool effects
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
                System.out.println("clicked");
            }
        };
    }
}
