package edu.baylor.ecs.csi3471;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class Window implements ActionListener {

    private static String login = "LogIn";
    private static String help = "Help";
    private static String createAcc = "Create Account";
    private static String title = "YoloTrader";
    private static String usernameStr = "Username: ";
    private static String passwordStr = "Password: ";
    private static String passwordAgainStr = "Re-enter Password: ";

    JFrame frame;

    private final static Logger logger = Logger.getLogger(Window.class.getName());

    public static void CreateWindow() {
        (new Window()).logIn();
    }

    public void logIn() {
        frame = new JFrame();

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
        JLabel passLabel = new JLabel(passwordStr);
        passLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField passText = new JTextField();

        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        logInPanel.add(userLabel);
        logInPanel.add(userText);
        logInPanel.add(passLabel);
        logInPanel.add(passText);
        mainPanel.add(logInPanel);

        // add button fields to pane
        buttonPanel.add(logInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);

        // add mainPanel to frame and set frame values
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void help() {
        frame = new JFrame();

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        // creating panels
        JPanel infoPanel = new JPanel(new GridLayout(1,1));
        JPanel titlePanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        // sign in button
        JButton signInButton = new JButton(login);
        JButton createAccButton = new JButton(createAcc);
        JButton helpButton = new JButton(help);

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("help pressed (help)");
            }
        });

        signInButton.addActionListener(this);
        createAccButton.addActionListener(this);

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
        JLabel passLabelConfirm = new JLabel("Re-enter Password: ");
        passLabelConfirm.setHorizontalAlignment(JLabel.CENTER);
        passLabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField passText = new JTextField();
        JTextField passTextConfirm = new JTextField();

        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        infoPanel.add(userLabel);
        infoPanel.add(userText);
        infoPanel.add(passLabel);
        infoPanel.add(passText);
        infoPanel.add(passLabelConfirm);
        infoPanel.add(passTextConfirm);
        mainPanel.add(infoPanel);

        // add button fields to pane
        buttonPanel.add(signInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);

        // add mainPanel to frame and set frame values
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createAccount() {
        frame = new JFrame();

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
        JTextField passText = new JTextField();
        JTextField passTextConfirm = new JTextField();

        // add title to pane
        titlePanel.add(appName);
        mainPanel.add(titlePanel);

        // add input fields
        signInPanel.add(userLabel);
        signInPanel.add(userText);
        signInPanel.add(passLabel);
        signInPanel.add(passText);
        signInPanel.add(passLabelConfirm);
        signInPanel.add(passTextConfirm);
        mainPanel.add(signInPanel);

        // add button fields to pane
        buttonPanel.add(signInButton);
        buttonPanel.add(helpButton);
        buttonPanel.add(createAccButton);
        mainPanel.add(buttonPanel);

        // add mainPanel to frame and set frame values
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(login)) {
            frame.dispose();
            logIn();
            System.out.println(login + " == " + e.getActionCommand());
        } else if (e.getActionCommand().equals(help)) {
            frame.dispose();
            help();
            System.out.println(help + " == " + e.getActionCommand());
        } else if (e.getActionCommand().equals(createAcc)) {
            frame.dispose();
            createAccount();
            System.out.println(createAcc + " == " + e.getActionCommand());
        }
    }
}
