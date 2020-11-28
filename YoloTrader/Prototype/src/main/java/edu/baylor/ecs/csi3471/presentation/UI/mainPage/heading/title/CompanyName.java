package edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.title;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

/**
 * @author owenmurphy
 */
public class CompanyName {

    public static String companyNameString = "YoloTrader";
    public static JLabel companyNameTitle;
    public static JPanel titlePanel;

    public static JPanel getTitlePanel() {
        titlePanel = new JPanel(new GridLayout(1, 1));
        titlePanel.setPreferredSize(new Dimension((int)(NorthPanelController.northPanelWidth / 2.25), NorthPanelController.northPanelHeight));
        titlePanel.setBackground(Color.WHITE);

        titlePanel.add(getTitleLabel());

        return titlePanel;
    }

    public static JLabel getTitleLabel() {
        companyNameTitle = new JLabel(companyNameString);
        companyNameTitle.setHorizontalAlignment(JLabel.LEFT);
        Font font = new Font("Futura", Font.BOLD, 30);
        companyNameTitle.setFont(font);

        return companyNameTitle;
    }
}
