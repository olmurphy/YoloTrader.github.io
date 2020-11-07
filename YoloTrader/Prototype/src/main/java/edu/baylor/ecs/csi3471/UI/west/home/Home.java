package edu.baylor.ecs.csi3471.UI.west.home;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Home {

    public static JFrame homeFrame;
    public static JPanel mainPanel;
    public static int frameWidth = 700;
    public static int frameHeight = 500;
    public static int westPanelWidth = 150;
    public static int westPanelHeight = frameHeight;
    public static int northPanelWidth = frameWidth;
    public static int northPanelHeight = 120;
    public static Border emptyBorder;
    public static String homeButtonString = "HOME";
    public static String profileButtonString = "PROFILE";
    public static String stocksButtonString = "STOCKS";
    public static String helpButtonString = "HELP";
    public static String aboutButtonString = "ABOUT";
    public static Color active = Color.GRAY;
    public static Color westPanelColor = Color.lightGray;




    public static void createUI () {
        homeFrame = new JFrame();
        homeFrame.setSize(new Dimension(frameWidth, frameHeight));
        mainPanel = new JPanel(new BorderLayout());
        emptyBorder = BorderFactory.createEmptyBorder();


        //mainPanel.setBackground(Color.GREEN);
        createNorthPanel();
        creatWestPanel();
        homeFrame.add(mainPanel);
        homeFrame.setVisible(true);
        homeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //public static void

    public static void createNorthPanel() {
        JPanel topPanel = new JPanel();

        topPanel.setPreferredSize(new Dimension(northPanelWidth, northPanelHeight));


        topPanel.add(new JLabel("top panel", JLabel.CENTER));
        topPanel.setBackground(Color.BLUE);

        mainPanel.add(topPanel, BorderLayout.NORTH);
    }

    public static void creatWestPanel() {
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

        westPanel.setPreferredSize(new Dimension(westPanelWidth, westPanelHeight));
        westPanel.setBackground(Color.MAGENTA);

        westPanel.add(getHomePanel());
        westPanel.add(getProfilePanel());
        westPanel.add(getStocksPanel());
        westPanel.add(getHelpPanel());
        westPanel.add(getAboutPanel());
        westPanel.setBackground(westPanelColor);

        mainPanel.add(westPanel, BorderLayout.WEST);
    }


    /*public static JButton getHomeButton() {
        JButton button = new JButton(homeButtonString);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);
        button.setBorder(emptyBorder);


        button.setBackground(westPanelColor);
        button.setOpaque(true);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setBackground(active);
                System.out.println("Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBackground(westPanelColor);
                System.out.println("Exited");

            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                System.out.println("Wheel Moved");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                System.out.println("Dragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });

        return button;
    }
    public static JButton getProfileButton() {
        JButton button = new JButton(profileButtonString);

        button.setBackground(westPanelColor);
        button.setOpaque(true);

        return button;
    }
    public static JButton getStocksButton() {
        JButton button = new JButton(stocksButtonString);

        button.setBackground(westPanelColor);
        button.setOpaque(true);

        return button;
    }
    public static JButton getHelpButton() {
        JButton button = new JButton(helpButtonString);

        button.setBackground(westPanelColor);
        button.setOpaque(true);

        return button;
    }
    public static JButton getAboutButton() {
        JButton button = new JButton(aboutButtonString);

        button.setBackground(westPanelColor);
        button.setOpaque(true);

        return button;
    }*/

    public static JPanel getHomePanel() {
        JPanel homePanel = new JPanel(new GridLayout(1,1));

        homePanel.add(new JLabel(homeButtonString, JLabel.CENTER));

        //homePanel.addMouseListener();

        homePanel.setBackground(westPanelColor);

        return homePanel;
    }


    public static JPanel getProfilePanel() {
        JPanel profilePanel = new JPanel(new GridLayout(1,1));

        profilePanel.add(new JLabel(profileButtonString, JLabel.CENTER));
        profilePanel.setBackground(westPanelColor);

        return profilePanel;
    }

    public static JPanel getStocksPanel() {
        JPanel stocksPanel = new JPanel(new GridLayout(1,1));

        stocksPanel.add(new JLabel(stocksButtonString, JLabel.CENTER));
        stocksPanel.setBackground(westPanelColor);

        return stocksPanel;
    }

    public static JPanel getHelpPanel() {
        JPanel helpPanel = new JPanel(new GridLayout(1,1));

        helpPanel.add(new JLabel(helpButtonString, JLabel.CENTER));
        helpPanel.setBackground(westPanelColor);

        return helpPanel;
    }

    public static JPanel getAboutPanel() {
        JPanel aboutPanel = new JPanel(new GridLayout(1,1));

        aboutPanel.add(new JLabel(aboutButtonString, JLabel.CENTER));
        aboutPanel.setBackground(westPanelColor);

        return aboutPanel;
    }



}
