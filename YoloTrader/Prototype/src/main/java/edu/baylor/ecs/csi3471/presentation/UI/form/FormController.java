package edu.baylor.ecs.csi3471.presentation.UI.form;

import edu.baylor.ecs.csi3471.dao.ProfileDAOImpl;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController;
import edu.baylor.ecs.csi3471.service.ProfileService;

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

    private static ProfileController profileController;

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
                //if (EmailValidator.validate(LogIn.getEmailField().getText().trim())) {
                    // FIXME: check the email credential to make sure it is unique
                    LogIn.getFrame().dispose();
                    MainPanel.createUI();
                //} else {
                    //LogIn.getEmptyFieldWarning();
                //}
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
        return e -> {

            // check for valid email format
            if (validCreateAccountFieldsNotEmpty()) {

                YoloTrader.logger.info("creating account...");

                /*profileController = new ProfileController(createNewProfile(),
                        new ProfileService(new ProfileDAOImpl()));

                profileController.addProfile(profileController.getProfile());*/

                CreateAccount.getFrame().dispose();
                MainPanel.createUI();
            }
            // FIXME: check the email credential to make sure it is unique

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
            System.out.println("email: " + LogIn.getEmailField().getText());
            allField = false;
        }

        if (LogIn.getPasswordField().getPassword().length == 0) {
            System.out.println("pass length: " + LogIn.getPasswordField().getPassword().length);

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
            System.out.println("email and pass are not valid");
            allField = false;
        }

        if (CreateAccount.getFirstField().getText().equals("")) {
            System.out.println("first name: " + CreateAccount.getFirstField().getText());
            allField = false;
        }

        if (CreateAccount.getLastField().getText().equals("")) {
            System.out.println("last name: " + CreateAccount.getLastField().getText());
            allField = false;
        }

        if (CreateAccount.getUserField().getText().equals("")) {
            System.out.println("user: " + CreateAccount.getUserField().getText());
            allField = false;
        }

        if (CreateAccount.getRe_passwordField().getPassword().length == 0) {
            System.out.println("re-pass length: " + CreateAccount.getRe_passwordField().getPassword().length);
            allField = false;
        }

        return allField;
    }

    public static Profile createNewProfile() {
        return new Profile(LogIn.getEmailField().getText(),
                CreateAccount.getUserField().getText(),
                new String(LogIn.getPasswordField().getPassword()),
                CreateAccount.getFirstField().getText(), CreateAccount.getLastField().getText());
    }

    public static ProfileController getProfileController() {
        return profileController;
    }
}
