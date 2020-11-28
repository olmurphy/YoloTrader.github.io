package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/**
 * @author owenmurphy
 */
public class HelpSection {

    public static JPanel helpPanel;
    public static JPanel FAQ_Panel;
    public static JPanel contact_Panel;
    public static JPanel whatAreStocksPanel;

    public static String helpString = "<html><span style=\"font-family:Arial;font-size:20px;\"><B>NEED HELP?</B>";
    public static String FAQ_String = "<html><span style=\"font-family:Arial;font-size:16px;\"><B>FAQ</B>";
    public static String whatAreStockString = "<html><span style=\"font-family:Arial;font-size:16px;\"><B>What Are Stocks?</B>";
    public static String contactString = "<html><span style=\"font-family:Arial;font-size:16px;\"><B>Contact</B>";

    public static JPanel getHelpPanel() {
        return helpPanel;
    }

    public static void setHelpPanel() {
        helpPanel = new JPanel();
        helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));
        helpPanel.setBackground(CenterPanelController.centerPanelColor); // setting color of help panel

        // FIXME: need to add all the components in Y_AXIS form
        helpPanel.add(getHelpLabel());
        helpPanel.add(getWhatAreStocksPanel());
        helpPanel.add(getContact_Panel());
        helpPanel.add(getFAQ_Panel());
    }

    public static JLabel getHelpLabel() {
        JLabel rtrn = new JLabel(helpString);
        rtrn.setForeground(Color.WHITE);
        rtrn.setFont(new Font("Futura", Font.PLAIN, 22));
        return rtrn;
        
    }

    public static JPanel getFAQ_Panel() {
        FAQ_Panel = new JPanel();
        FAQ_Panel.setLayout(new BoxLayout(FAQ_Panel, BoxLayout.Y_AXIS));
        FAQ_Panel.setBackground(CenterPanelController.centerPanelColor);

        FAQ_Panel.add(getFAQLabel());

        return FAQ_Panel;
    }

    public static JLabel getFAQLabel() {
    	JLabel rtrn = new JLabel(FAQ_String);
        rtrn.setForeground(Color.WHITE);
        rtrn.setFont(new Font("Futura", Font.PLAIN, 22));
        return rtrn;
    }

    public static JPanel getContact_Panel() {
        contact_Panel = new JPanel();
        contact_Panel.setLayout(new BoxLayout(contact_Panel, BoxLayout.Y_AXIS));
        contact_Panel.setBackground(CenterPanelController.centerPanelColor);

        contact_Panel.add(getContactLabel());

        return contact_Panel;
    }

    public static JLabel getContactLabel() {
    	JLabel rtrn = new JLabel(contactString);
        rtrn.setForeground(Color.WHITE);
        rtrn.setFont(new Font("Futura", Font.PLAIN, 22));
        return rtrn;
    }

    public static JPanel getWhatAreStocksPanel() {
        whatAreStocksPanel = new JPanel();
        whatAreStocksPanel.setLayout(new BoxLayout(whatAreStocksPanel, BoxLayout.Y_AXIS));
        whatAreStocksPanel.setBackground(CenterPanelController.centerPanelColor);

        whatAreStocksPanel.add(getWhatAreStockLabel());

        return whatAreStocksPanel;
    }

    public static JLabel getWhatAreStockLabel() {
    	JLabel rtrn = new JLabel(whatAreStockString);
        rtrn.setForeground(Color.WHITE);
        rtrn.setFont(new Font("Futura", Font.PLAIN, 22));
        return rtrn;
    }
}
