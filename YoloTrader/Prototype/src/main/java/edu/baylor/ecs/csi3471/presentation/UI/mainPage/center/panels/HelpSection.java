package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;

/**
 * @author owenmurphy
 */
public class HelpSection {

    public static JPanel helpPanel;
    public static JPanel FAQ_Panel;
    public static JPanel contact_Panel;
    public static JPanel whatAreStocksPanel;

    public static String leftHeaderLabel = "<html><span style=\"font-family:Futura;font-size:16px;color:white;\"><B>";
    public static String rightHeaderLabel = "</B></span></html>";

    public static String helpString = "<html><span style=\"" +
            "font-family:Futura;" +
            "font-size:20px;" +
            "color:white\">" +
            "<B>NEED HELP?</B>";

    public static String FAQ_String = leftHeaderLabel + "FAQ" + rightHeaderLabel;
    public static String whatAreStockString = leftHeaderLabel + "What Are Stocks?" + rightHeaderLabel;
    public static String contactString = leftHeaderLabel + "Contact" + rightHeaderLabel;

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
        return new JLabel(helpString);
    }

    public static JPanel getFAQ_Panel() {
        FAQ_Panel = new JPanel();
        FAQ_Panel.setLayout(new BoxLayout(FAQ_Panel, BoxLayout.Y_AXIS));
        FAQ_Panel.setBackground(CenterPanelController.centerPanelColor);

        FAQ_Panel.add(getFAQLabel());

        return FAQ_Panel;
    }

    public static JLabel getFAQLabel() {
    	return new JLabel(FAQ_String);
    }

    public static JPanel getContact_Panel() {
        contact_Panel = new JPanel();
        contact_Panel.setLayout(new BoxLayout(contact_Panel, BoxLayout.Y_AXIS));
        contact_Panel.setBackground(CenterPanelController.centerPanelColor);

        contact_Panel.add(getContactLabel());

        return contact_Panel;
    }

    public static JLabel getContactLabel() {
    	return new JLabel(contactString);
    }

    public static JPanel getWhatAreStocksPanel() {
        whatAreStocksPanel = new JPanel();
        whatAreStocksPanel.setLayout(new BoxLayout(whatAreStocksPanel, BoxLayout.Y_AXIS));
        whatAreStocksPanel.setBackground(CenterPanelController.centerPanelColor);

        whatAreStocksPanel.add(getWhatAreStockLabel());

        return whatAreStocksPanel;
    }

    public static JLabel getWhatAreStockLabel() {
    	return new JLabel(whatAreStockString);
    }
}
