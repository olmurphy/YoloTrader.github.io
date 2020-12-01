package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @author owenmurphy
 */
public class AboutSection {

    public static JPanel mainAboutPanel;
    public static JPanel aboutPanel;
    public static JPanel developersPanel;

    public static JLabel aboutLabelText;
    public static JLabel developerLabelText;

    public static String aboutString = "<html><span style=\"font-family:Futura;font-size:16px;color:white\"><B>ABOUT</B>";
    public static String developerString = "<html><span style=\"font-family:Futura;font-size:16px;color:white\"><B>DEVELOPERS</B>";

     public static String developerLabelString = "<html>" +
             "<ul>" +
            "<li style=color:white;font-family:Futura>Owen Murphy [ Leader ] (responsibilities):</li>" +
                "<ul>" +
                    "<li style=color:white;font-family:Futura>Analysis and Design</li>" +
                    "<li style=color:white;font-family:Futura>User Interface</li>" +
                    "<li style=color:white;font-family:Futura>Database Configuration</li>" +
                "</ul>" +
            "<li style=color:white;font-family:Futura>Prince Kalu [ Chief Software Engineer ] (responsibilities):</li>" +
                "<ul>" +
                    "<li style=color:white;font-family:Futura>Analysis and Design</li>" +
                    "<li style=color:white;font-family:Futura>User Interface</li>" +
                    "<li style=color:white;font-family:Futura>Backend Development</li>"+
                    "<li style=color:white;font-family:Futura>Middleware Development</li>"+
                    "<li style=color:white;font-family:Futura>Machine Learning Development</li>"+
                "</ul>" + "</html";

    public static JPanel getMainAboutPanel() { return mainAboutPanel; }

    public static void setMainAboutPanel() {
        mainAboutPanel = new JPanel();
        mainAboutPanel.setLayout(new BoxLayout(mainAboutPanel, BoxLayout.Y_AXIS));
        mainAboutPanel.setBackground(CenterPanelController.centerPanelColor);

        mainAboutPanel.add(getAboutPanel());
        mainAboutPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainAboutPanel.add(getDevelopersPanel());
    }

    public static JPanel getAboutPanel() {
        aboutPanel = new JPanel();
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        aboutPanel.setBackground(CenterPanelController.centerPanelColor);

        // add about title
        aboutPanel.add(getAboutLabel());

        // add the about description
        setAboutLabelText(loadAboutLabelText());
        aboutPanel.add(getAboutLabelText());

        return aboutPanel;
    }

    public static JPanel getDevelopersPanel() {
        developersPanel = new JPanel();
        developersPanel.setLayout(new BoxLayout(developersPanel, BoxLayout.Y_AXIS));
        developersPanel.setBackground(CenterPanelController.centerPanelColor);

        // adding developer title
        developersPanel.add(getDeveloperLabel());

        // adding developer list
        setDeveloperLabelText(new JLabel(developerLabelString));
        developersPanel.add(getDeveloperLabelText());

        return developersPanel;
    }

    public static JLabel getAboutLabel() { return new JLabel(aboutString); }

    public static JLabel getDeveloperLabel() { return new JLabel(developerString); }

    public static void setAboutLabelText(JLabel aboutLabelText) { AboutSection.aboutLabelText = aboutLabelText; }

    public static JLabel getAboutLabelText() { return aboutLabelText; }

    public static JLabel loadAboutLabelText() {
        JLabel label = new JLabel();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/resources/About.txt")))))
        {
            StringBuilder str = new StringBuilder("<html><span style=\"font-family:Futura;color:white\">");
            String line;

            while ((line = br.readLine()) != null) { str.append(line).append(" "); }

            label.setText(str.append("</span></html>").toString());

        } catch (IOException e) { e.printStackTrace(); }
        return label;
    }

    public static void setDeveloperLabelText(JLabel developerLabelText) { AboutSection.developerLabelText = developerLabelText; }

    public static JLabel getDeveloperLabelText() { return developerLabelText; }
}
