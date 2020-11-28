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

    public static String aboutString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>ABOUT</B>";
    public static String developerString = "<html><span style=\"font-family:Arial;font-size:14px;\"><B>DEVELOPERS</B>";

     public static String developerLabelString = "<html><ul>" +
            "<li>Owen Murphy [Leader] (responsibilities):</li>" +
                "<ul>" +
                    "<li>User Interface</li>" +
                    "<li>Analysis and Design</li>" +
                    "<li>Database Configuration</li>" +
                "</ul>" +
            "<li>Prince Kalu (responsibilities):</li>" +
                "<ul>" +
                    "<li>Analysis and Design</li>" +
                    "<li>Backend Development</li>"+
                    "<li>Middleware Development</li>"+
                "</ul>" +
            "</html";

    public static JPanel getMainAboutPanel() {
        return mainAboutPanel;
    }

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

    public static JLabel getAboutLabel() {
    	JLabel rtrn = new JLabel(aboutString);
        rtrn.setForeground(Color.WHITE);
        rtrn.setFont(new Font("Futura", Font.PLAIN, 16));
        return rtrn;
    }

    public static JLabel getDeveloperLabel() {
    	JLabel rtrn = new JLabel(developerString);
        return rtrn;
    }

    public static void setAboutLabelText(JLabel aboutLabelText) {
        AboutSection.aboutLabelText = aboutLabelText;
        AboutSection.aboutLabelText.setForeground(Color.WHITE);
    	AboutSection.aboutLabelText.setFont(new Font("Futura", Font.PLAIN, 14));
    }

    public static JLabel getAboutLabelText() {
        return aboutLabelText;
        
    }

    public static JLabel loadAboutLabelText() {
        JLabel label = new JLabel();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/resources/About.txt")))))
        {
            StringBuilder str = new StringBuilder("<html>");
            String line = null;

            while ((line = br.readLine()) != null) {
                str.append(line).append(" ");
            }
            str.append("</html>");

            label.setText(str.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return label;
    }

    public static void setDeveloperLabelText(JLabel developerLabelText) {
        AboutSection.developerLabelText = developerLabelText;
        AboutSection.developerLabelText.setForeground(Color.WHITE);
    	AboutSection.developerLabelText.setFont(new Font("Futura", Font.PLAIN, 14));
    }

    public static JLabel getDeveloperLabelText() {
    	developerLabelText.setForeground(Color.WHITE);
        developerLabelText.setFont(new Font("Futura", Font.PLAIN, 16));
        return developerLabelText;
    }
}
