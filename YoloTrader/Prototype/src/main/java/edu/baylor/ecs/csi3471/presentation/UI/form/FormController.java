package edu.baylor.ecs.csi3471.presentation.ui.form;

import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.MainPanelController;
import org.apache.commons.validator.routines.EmailValidator;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * handles the actions for the buttons present on the ${@link CreateAccount}, ${@link LogIn}
 * ${@link Help} forms
 * @author owenmurphy
 */
public class FormController {

    /** value for login button */
    public static String login = "LogIn";

    /** value for help button */
    public static String help = "Help";

    /** value for createAcc button */
    public static String createAcc = "Create Account";

    /** company name */
    public static String title = "YoloTrader";

    /** this is the color of the whole application interface the user will have */
    public static Color formColor = MainPanel.backGroundColor;

    /** html formatting for the left side of label */
    public static String leftLabelSide = "<html><span style=\"font-family:Futura;color:white;font-size:16px;\">";

    /** html formatting for the ride side of label */
    public static String rightLabelSide = "</span></html>";

    /** html formatting for the left side of button */
    public static String leftButtonSide = "<html><span style=\\\"font-family:Futura;color:white;font-size:16px;\">";

    /** html formatting for the right side of button */
    public static String rightButtonSide = "</span></html>";

    /**
     * method to start the application, the application will start in the log-in page
     *
     * In addition, this method allows for low coupling between classes
     */
    public static void getStartFrame() { initialize(); LogIn.startFrame(); }

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
                    CreateAccount.getFrame().dispose(); // dispose create account form
                    LogIn.startFrame(); // start the login form

                    YoloTrader.logger.info("switch to log-in");
                } else if (e.getActionCommand().equals(help)) {
                    YoloTrader.logger.info("got to help");
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

                if (MainPanelController.getProfileController().checkCredentials(LogIn.getEmailField().getText(),
                        new String(LogIn.getPasswordField().getPassword()))) {

                    YoloTrader.logger.info("logging in");

                    LogIn.getFrame().dispose();
                    MainPanel.createUI();
                } else { LogIn.getInvalidCredentialsWarning(); }

            } else { LogIn.getEmptyFieldWarning(); }
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
            String email;

            // check that all fields are not empty
            if (!validCreateAccountFieldsNotEmpty()) { LogIn.getEmptyFieldWarning(); }

            // check that the email used is a valid email
            else if (!EmailValidator.getInstance().isValid(email = LogIn.getEmailField().getText())) { Email.getEmailNotValidWarning(); }

            // check that the passwords match
            else if (!checkPassMatch()) { CreateAccount.getPassNotMatchWarning(); }

            // check that the email is unique
            else if (!MainPanelController.getProfileController().isNotEmailUnique(email)) { Email.getEmailWarning(); }

            // check that user's is inputting the correct verification code sent to their email
            else if (!Email.getEmailSentCodeValidation(email)) { Email.getEmailValidationCodeNotValid(); }

            // all is good, start making account
            else {
                Profile profile = createNewProfile();
                MainPanelController.getProfileController().addProfile(profile);
                MainPanelController.getProfileController().setProfile(profile);
                MainPanelController.getProfileController().saveProfiles();
                CreateAccount.getFrame().dispose();
                MainPanel.createUI();
                YoloTrader.logger.info("creating account...");
            }
        };
    }

    /**
     * checks if email and password fields are not empty
     *
     * @return true if no fields are empty
     */
    public static boolean validateLogInFieldsNotEmpty() { return !LogIn.getEmailField().getText().equals("") && LogIn.getPasswordField().getPassword().length != 0; }

    /**
     * check if first, last, username, re-password fields are not empty.
     * Also calls {@link #validateLogInFieldsNotEmpty()} to check email
     * and password fields not empty
     *
     * @return true if the fields are not empty, false otherwise
     */
    public static boolean validCreateAccountFieldsNotEmpty() {
        return (validateLogInFieldsNotEmpty() && !CreateAccount.getFirstField().getText().equals("")
        && !CreateAccount.getLastField().getText().equals("") && !CreateAccount.getUserField().getText().equals("")
        && CreateAccount.getRe_passwordField().getPassword().length != 0);
    }

    /**
     * creates a new profile given the input fields from user
     * @return a new profile instance
     */
    public static Profile createNewProfile() {
        return new Profile(LogIn.getEmailField().getText(), CreateAccount.getUserField().getText(),
                new String(LogIn.getPasswordField().getPassword()),
                CreateAccount.getFirstField().getText(), CreateAccount.getLastField().getText());
    }

    /**
     * calls ${@link MainPanelController#initializeProfileController()} to initialize the profile controller
     * and all the profiles in YoloTrader Application
     */
    public static void initialize() { MainPanelController.initializeProfileController(); }

    /**
     * @return true if the two passwords entered match, false o.w.
     */
    public static boolean checkPassMatch() { return Arrays.equals(LogIn.getPasswordField().getPassword(), CreateAccount.getRe_passwordField().getPassword()); }

    /**
     * the logic to the forgot password button given the email that the user inputs
     * @return actionListener for the forgotPassword button
     */
    public static ActionListener getForgotPasswordButtonListener() {
        return e -> {
            String email = Email.getEmailInputDialog(); // get email from user

            // check if password was changed given the email (email to recipient is also sent if condition is true)
            if (MainPanelController.getProfileController().recoverPassword(email)) {
                YoloTrader.logger.info("Changed password");

                MainPanelController.getProfileController().saveProfiles(); // save to database

                Email.getPasswordChangedSuccessful(); // let user know the password was successfully changed
            } else { Email.getEmailNotFound(); } // display warning
        };
    }
}
