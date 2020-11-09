package edu.baylor.ecs.csi3471.UI.form;

import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FormController {

    public static String login = "LogIn";
    public static String help = "Help";
    public static String createAcc = "Create Account";
    public static String title = "YoloTrader";
    public static String usernameStr = "Username: ";
    public static String passwordStr = "Password: ";
    public static int width = 350;
    public static int height = 500;
    public static JFrame frame;


    public static void startWindowInLogIn() {
        LogIn.logIn();
    }

    public static ActionListener getGeneralFormAction(String action, JFrame frame) {
        return e -> {
            if (!action.equals(e.getActionCommand())) {
                if (e.getActionCommand().equals(login)) {
                    frame.dispose();
                    LogIn.logIn();
                    YoloTrader.logger.info(login + " == " + e.getActionCommand());
                } else if (e.getActionCommand().equals(help)) {
                    Help.createHelp();
                    YoloTrader.logger.info(help + " == " + e.getActionCommand());
                } else if (e.getActionCommand().equals(createAcc)) {
                    frame.dispose();
                    CreateAccount.createAccount();
                    YoloTrader.logger.info(createAcc + " == " + e.getActionCommand());
                }
            }
        };
    }

    public static JFrame getFrame() {
        return frame;
    }
}
