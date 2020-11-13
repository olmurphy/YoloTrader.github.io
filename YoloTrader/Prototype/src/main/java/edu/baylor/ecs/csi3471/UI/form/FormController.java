package edu.baylor.ecs.csi3471.UI.form;

import edu.baylor.ecs.csi3471.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormController {

    public static String login = "LogIn";
    public static String help = "Help";
    public static String createAcc = "Create Account";
    public static String title = "YoloTrader";

    public static Color formColor = MainPanel.backGroundColor;

    public static void getStartFrame() {
        LogIn.startWindowInLogIn();
    }

    public static ActionListener getGeneralFormAction(String action) {
        return e -> {
            if (!action.equals(e.getActionCommand())) {
                if (e.getActionCommand().equals(login)) {

                    CreateAccount.getFrame().dispose();
                    LogIn.startWindowInLogIn();

                    YoloTrader.logger.info("switch to log-in");
                } else if (e.getActionCommand().equals(help)) {

                    YoloTrader.logger.info("go to help");
                    Help.createHelp();

                } else if (e.getActionCommand().equals(createAcc)) {

                    LogIn.getFrame().dispose();
                    CreateAccount.startCreateAccount();
                    YoloTrader.logger.info("switch to create an account");
                }
            }
        };
    }

    public static ActionListener getCreateAccountAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                // check for valid email format
                if (EmailValidator.validate(LogIn.getEmailField().getText().trim())) {

                    // FIXME: check the email credential to make sure it is unique
                    CreateAccount.getFrame().dispose();
                    MainPanel.createUI("Owen");
                } else {
                    LogIn.getEmailWarning();
                }

                YoloTrader.logger.info("creating an account");

            }
        };
    }

    public static ActionListener getLogInAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // check for valid email format
                if (EmailValidator.validate(LogIn.getEmailField().getText().trim())) {
                    // FIXME: check the email credential to make sure it is unique
                    LogIn.getFrame().dispose();
                    MainPanel.createUI("Owen");
                } else {
                    LogIn.getEmailWarning();
                }
                // FIXME: need to add action

                YoloTrader.logger.info("logging in");
            }
        };
    }

}
