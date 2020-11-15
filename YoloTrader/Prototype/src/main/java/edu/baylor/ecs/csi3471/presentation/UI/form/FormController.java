package edu.baylor.ecs.csi3471.presentation.UI.form;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.main.YoloTrader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormController {

    /** value for login button */
    public static String login = "LogIn";

    /** value for help button */
    public static String help = "Help";

    /** value for createAcc button */
    public static String createAcc = "Create Account";

    /** project title */
    public static String title = "YoloTrader";

    /** this is the color of the whole application interface the user will have */
    public static Color formColor = MainPanel.backGroundColor;

    /**
     * method to start the application, the application will start in the log-in page
     *
     * In addition, this method allows for low coupling between classes
     */
    public static void getStartFrame() {
        LogIn.startFrame();
    }

    /**
     * method redirects user to appropriate page that is NOT the same page the user is already on.
     *
     * For example, if user is on Log-In page and presses "create Account" then they will be re-directed to the create
     * account page
     *
     * @param action defined to be either 'login', 'help', or 'creatAcc' static variables
     * @return ActionListener for each button
     */
    public static ActionListener getGeneralFormAction(String action) {
        return e -> {
            if (!action.equals(e.getActionCommand())) {
                if (e.getActionCommand().equals(login)) {

                    CreateAccount.getFrame().dispose();
                    LogIn.startFrame();

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

    /**
     * this method generates an action when user pressed Log-In button.
     *
     * FIXME: need confirm user credentials and log-in the user if valid credentials, otherwise, generating error message
     *
     * @return ActionListener for the Log-In button when pressed
     */
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
                    LogIn.getEmptyFieldWarning();
                }
                // FIXME: need to add action

                YoloTrader.logger.info("logging in");
            }
        };
    }

    /**
     * generates an action upon user clicking the create account button. calls {@link #validCreateAccountFieldsNotEmpty()}
     * to check that all fields not empty,
     *
     * FIXME: need to create profile and set up user's homepage and profile page
     *
     * @return ActionListener for the createAccount button
     */
    public static ActionListener getCreateAccountAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // check for valid email format

                if (validCreateAccountFieldsNotEmpty()) {


                    YoloTrader.logger.info("creating account...");
                    CreateAccount.getFrame().dispose();
                }
                // FIXME: check the email credential to make sure it is unique

                MainPanel.createUI("Owen");
            }
        };
    }


    /**
     * checks if email and password fields are not empty
     *
     * @return true if no fields are empty
     */
    public static boolean validateLogInFieldsNotEmpty() {
        boolean allField = true;

        if (LogIn.getEmailField().getText().equals("")) {
            allField = false;
        }

        if (LogIn.getPasswordField().getPassword().length == 0) {
            allField = false;
        }

        return allField;
    }

    /**
     * check if first, last, username, re-password fields are not empty.
     * Also calls {@link #validCreateAccountFieldsNotEmpty()} to check email
     * and password fields not empty
     *
     * @return true if the fields are not empty, false otherwise
     */
    public static boolean validCreateAccountFieldsNotEmpty() {
        boolean allField = true;

        if (!validateLogInFieldsNotEmpty()) {
            allField = false;
        }

        if (CreateAccount.getFirstField().getText().equals("")) {
            allField = false;
        }

        if (CreateAccount.getFirstField().getText().equals("")) {
            allField = false;
        }

        if (CreateAccount.getUserField().getText().equals("")) {
            allField = false;
        }

        if (CreateAccount.getRe_passwordField().getPassword().length == 0) {
            allField = false;
        }

        return allField;
    }
}
