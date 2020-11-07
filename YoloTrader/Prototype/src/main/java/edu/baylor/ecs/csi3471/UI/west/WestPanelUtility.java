package edu.baylor.ecs.csi3471.UI.west;

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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                // FIXME: record the action hear

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                // FIXME: add cool effects
            }

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
}
