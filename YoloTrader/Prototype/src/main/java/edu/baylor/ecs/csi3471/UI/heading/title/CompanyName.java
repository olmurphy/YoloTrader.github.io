package edu.baylor.ecs.csi3471.UI.heading.title;

import edu.baylor.ecs.csi3471.UI.heading.NorthPanelController;

import javax.swing.*;
import java.awt.*;

public class CompanyName {

    public static String companyNameString = "YoloTrader";
    public static JLabel companyNameTitle;
    public static JPanel titlePanel;


    public static JPanel getTitlePanel() {
        titlePanel = new JPanel(new GridLayout(1, 1));
        titlePanel.setPreferredSize(new Dimension((int)(NorthPanelController.northPanelWidth / 2.25), NorthPanelController.northPanelHeight));
        titlePanel.setBackground(Color.red);

        titlePanel.add(getTitleLabel());

        return titlePanel;
    }

    public static JLabel getTitleLabel() {
        companyNameTitle = new JLabel(companyNameString);
        companyNameTitle.setHorizontalAlignment(JLabel.LEFT);
        Font font = new Font("Sans-Serif", Font.BOLD, 30);
        companyNameTitle.setFont(font);

        return companyNameTitle;
    }


}
