package edu.baylor.ecs.csi3471;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import java.util.logging.LogManager;

public class Window implements ActionListener {

    public static String login = "LogIn";
    public static String help = "Help";
    public static String createAcc = "Create Account";
    public static String title = "YoloTrader";
    public static String usernameStr = "Username: ";
    public static String passwordStr = "Password: ";
    public static String passwordAgainStr = "Re-enter Password: ";
    public static int width = 350;
    public static int height = 500;

    static JFrame frame;

    private final static Logger logger = Logger.getLogger(Window.class.getName());


    static {
        try {
            InputStream configFile = Window.class.getClassLoader().getResourceAsStream("logger.properties");
            LogManager.getLogManager().readConfiguration(configFile);
            assert configFile != null;
            configFile.close();
        } catch (IOException ex) {
            System.out.println("WARNING: Could not open configuration file");
            System.out.println("WARNING: Logging not configured (console output only)");
        }
        logger.info("starting the app");
    }

    public static void CreateWindow() {
        (new Window()).logIn();
    }

    public void logIn() {
        frame = new JFrame("Log-In");

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        // creating panels
        JPanel logInPanel = new JPanel(new GridLayout(4,1));
        JPanel titlePanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        // sign in button
        JButton logInButton = new JButton(login);
        JButton createAccButton = new JButton(createAcc);
        JButton helpButton = new JButton(help);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("SignIn pressed (logIn)");
            }
        });

        createAccButton.addActionListener(this);
        helpButton.addActionListener(this);

        // App name title
        JLabel appName = new JLabel(title);
        appName.setVerticalAlignment(JLabel.CENTER);
        appName.setHorizontalAlignment(JLabel.CENTER);

        // create username fields
        JLabel userLabel = new JLabel(usernameStr);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField userText = new JTextField();

        // create password fields
        JPasswordField passwordField = new JPasswordField();
        JLabel passLabel = new JLabel(passwordStr);
        passLabel.setHorizontalAlignment(JLabel.CENTER);

        // adding color to buttons
        logInButton.setBackground(Color.CYAN);
        createAccButton.setBackground(Color.CYAN);
        helpButton.setBackground(Color.CYAN);
        logInButton.setOpaque(true);
        createAccButton.setOpaque(true);
        helpButton.setOpaque(true);


        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        logInPanel.add(userLabel);
        logInPanel.add(userText);
        logInPanel.add(passLabel);
        logInPanel.add(passwordField);
        mainPanel.add(logInPanel);

        // add button fields to pane
        buttonPanel.add(logInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);

        // add mainPanel to frame and set frame values
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void help() {
        frame = new JFrame("Help");

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        // creating panels
        JPanel infoPanel = new JPanel(new GridLayout(1,1));
        JPanel titlePanel = new JPanel(new BorderLayout());

        JButton helpButton = new JButton(help);
        JLabel emailHelpLabel = new JLabel("volatiles.stocks@gmail.com");
        emailHelpLabel.setHorizontalAlignment(JLabel.LEFT);

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("help pressed (help)");
            }
        });


        // App name title
        JLabel appName = new JLabel(title);
        appName.setVerticalAlignment(JLabel.CENTER);
        appName.setHorizontalAlignment(JLabel.CENTER);

        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add help contact to pane
        infoPanel.add(emailHelpLabel);
        mainPanel.add(infoPanel);


        // add mainPanel to frame and set frame values
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void createAccount() {
        frame = new JFrame("Create Account");

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        // creating panels
        JPanel signInPanel = new JPanel(new GridLayout(6,1));
        JPanel titlePanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        // sign in button
        JButton signInButton = new JButton(login);
        JButton createAccButton = new JButton(createAcc);
        JButton helpButton = new JButton(help);

        helpButton.addActionListener(this);

        createAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("Create Account pressed (createAccount)");
            }
        });

        signInButton.addActionListener(this);

        // App name title
        JLabel appName = new JLabel(title);
        appName.setVerticalAlignment(JLabel.CENTER);
        appName.setHorizontalAlignment(JLabel.CENTER);

        // create username fields
        JLabel userLabel = new JLabel(usernameStr);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField userText = new JTextField();

        // create password fields
        JLabel passLabel = new JLabel(passwordStr);
        JLabel passLabelConfirm = new JLabel(passwordAgainStr);
        passLabelConfirm.setHorizontalAlignment(JLabel.CENTER);
        passLabel.setHorizontalAlignment(JLabel.CENTER);
        JPasswordField passwordField = new JPasswordField();
        JPasswordField passwordFieldConfirm = new JPasswordField();

        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        signInPanel.add(userLabel);
        signInPanel.add(userText);
        signInPanel.add(passLabel);
        signInPanel.add(passwordField);
        signInPanel.add(passwordField);
        signInPanel.add(passwordFieldConfirm);
        mainPanel.add(signInPanel);

        // add button fields to pane
        buttonPanel.add(signInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);

        // add mainPanel to frame and set frame values
        frame.add(mainPanel);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(login)) {
            frame.dispose();
            logIn();
            logger.info(login + " == " + e.getActionCommand());
        } else if (e.getActionCommand().equals(help)) {
            help();
            logger.info(help + " == " + e.getActionCommand());
        } else if (e.getActionCommand().equals(createAcc)) {
            frame.dispose();
            createAccount();
            logger.info(createAcc + " == " + e.getActionCommand());
        }
    }
}
