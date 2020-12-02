package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.title;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class CompanyName {

    public static String companyNameString = "<html><span style=\"font-family:Futura;color:white;font-size:30px\">" +
            "YoloTrader" + "</span></html>";
    public static JLabel companyNameTitle;
    public static JPanel titlePanel;

    public static JPanel getTitlePanel() {
        titlePanel = new JPanel(new GridLayout(1, 1));
        titlePanel.setPreferredSize(new Dimension((int)(NorthPanelController.northPanelWidth / 2.25), NorthPanelController.northPanelHeight));
        titlePanel.setBackground(NorthPanelController.northPanelColor);

        titlePanel.add(getTitleLabel());

        return titlePanel;
    }

    public static JLabel getTitleLabel() {
        companyNameTitle = new JLabel(companyNameString);
        companyNameTitle.setHorizontalAlignment(JLabel.LEFT);

        return companyNameTitle;
    }
}
