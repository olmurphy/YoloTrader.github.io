package edu.baylor.ecs.csi3471.UI.west.help;

import edu.baylor.ecs.csi3471.UI.west.WestPanelUtility;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Help {

    public static JPanel helpPanel;
    public static String helpButtonString = "HELP";

    public static JPanel getHelpPanel() {
        helpPanel = WestPanelUtility.getEachWestSubPanel();

        JLabel helpLabel = new JLabel(helpButtonString, JLabel.CENTER);
        helpLabel.setFont(WestPanelUtility.panelLabelFonts);
        helpPanel.add(helpLabel);
        helpPanel.setBackground(WestPanelUtility.westPanelColor);
        helpPanel.addMouseListener(WestPanelUtility.getGeneralWestPanelActions(helpPanel));
        helpPanel.addMouseListener(getHelpPanelAction());

        return helpPanel;
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
}
