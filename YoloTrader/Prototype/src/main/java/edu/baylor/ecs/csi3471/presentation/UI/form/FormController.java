package edu.baylor.ecs.csi3471.presentation.UI.form;

import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * @author owenmurphy
 */
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

    /** controller that the form controller uses to control the creating a new profile and logging into existing */
    private static ProfileController profileController;

    /**
     * method to start the application, the application will start in the log-in page
     *
     * In addition, this method allows for low coupling between classes
     */
    public static void getStartFrame() {
        initialize();
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
     * @return ActionListener for the Log-In button when pressed
     */
    public static ActionListener getLogInAction() {
        return e -> {

            // check for valid email format
            if (validateLogInFieldsNotEmpty()) {

                Profile profile = profileController.checkCredentials(LogIn.getEmailField().getText(),
                        new String(LogIn.getPasswordField().getPassword()));

                if (profile != null) {
                    YoloTrader.logger.info("logging in");
                    profileController.setProfile(profile);

                    LogIn.getFrame().dispose();
                    MainPanel.createUI();
                } else {
                    LogIn.getInvalidCredentialsWarning();
                }

            } else {
                LogIn.getEmptyFieldWarning();
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

            // check that all fields are not empty
            if (validCreateAccountFieldsNotEmpty()) {

                boolean proceed = true;
                YoloTrader.logger.info("check that email input is unique");

                Profile profile = createNewProfile();

                if (!checkPassMatch()) {
                    proceed = false;
                    CreateAccount.getPassNotMatchWarning();
                }

                if (proceed && profileController.addProfile(profile) ) {
                    profileController.setProfile(profile);
                    CreateAccount.getFrame().dispose();
                    MainPanel.createUI();
                    YoloTrader.logger.info("creating account...");

                } else if (proceed){
                    Email.getEmailWarning();
                }

            } else {
                LogIn.getEmptyFieldWarning();
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

    /**
     * creates a new profile given the input fields from user
     * @return a new profile instance
     */
    public static Profile createNewProfile() {
        return new Profile(LogIn.getEmailField().getText(),
                CreateAccount.getUserField().getText(),
                new String(LogIn.getPasswordField().getPassword()),
                CreateAccount.getFirstField().getText(), CreateAccount.getLastField().getText());
    }

    public static ProfileController getProfileController() {
        return profileController;
    }

    /**
     * initializes the profile controller and all the profiles in YoloTrader Application
     */
    public static void initialize() {
        profileController = new ProfileController(null);
        profileController.loadProfiles();
    }

    public static boolean checkPassMatch() {
        return Arrays.equals(LogIn.getPasswordField().getPassword(), CreateAccount.getRe_passwordField().getPassword());
    }

    /**
     * the logic to the forgot password button given the email that the user inputs
     * @return actionListener for the forgotPassword button
     */
    public static ActionListener getForgotPasswordButtonListener() {
        return e -> {

            // get email from user
            String email = Email.getEmailInputDialog();

            // check if password was changed given the email (email to recipient is also sent if condition is true)
            if (profileController.recoverPassword(email)) {
                YoloTrader.logger.info("Changed password");

                // let user know the password was successfully changed
                Email.getPasswordChangedSuccessful();
            } else {
                // display warning
                Email.getEmailNotFound();
            }
        };
    }
}
