package edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.pages;

import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.presentation.ui.form.Email;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.MainPanelController;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.center.panels.ProfileSection;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.heading.search.Name;
import org.apache.commons.validator.routines.EmailValidator;

import javax.swing.*;
import java.util.Arrays;

/**
 * this class displays various dialogs such as warning and inputs.
 * In addition, it handles changing password and editing profile logic
 *
 * @author owenmurphy
 */
public class Dialogs {

    /** dialog opens to ask user for name of watch list to create and returns it
     * @return the name the user inputs */
    public static String watchListNameWindow() { return JOptionPane.showInputDialog("Enter watch list name:"); }

    /** warning dialog informs user that name of watch list to create is already taken */
    public static void getWatchListNameTaken() {
        JOptionPane.showMessageDialog(null, "Name Taken", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /** displays warning if the user has not selected watch list to perform an action on */
    public static void getNoWatchListSelectedWarning() {
        JOptionPane.showMessageDialog(null, "Need to select a watchList to add to",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /** displays warning informing the user that no stock is selected to perform an action on */
    public static void getNoStockSelectedWarning() {
        JOptionPane.showMessageDialog(null, "No stock is selected to delete",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /** asks for the user to input the stock name to search */
    public static String getAddStockInputDialog() {
        return JOptionPane.showInputDialog(null, "Enter stock name to search",
                "Add Stock", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * input dialog asks the user for the password of the account to delete
     * @return user input for the password of the account
     */
    public static String getPassWordDialog() {
        JPasswordField pass = new JPasswordField();
        Object []m = { "Enter Password: ", pass};

        return ((JOptionPane.showConfirmDialog(null, m, "Delete Account", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.CANCEL_OPTION)
                ? null : new String(pass.getPassword()));
    }

    /** display to the user that the password passed in was incorrect */
    public static void getPasswordNotCorrectWarning() {
        JOptionPane.showMessageDialog(null, "password was incorrect", "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * dialog asks the user for the old password, new pass, and new pass again.
     * checks if old pass match, if so, it checks if the 2 new pass' match
     * if the 2 match, it changes the user's password to their profile
     * if any of these checks fail, it displays a warning dialog for them
     */
    public static void getChangePassDialog() {
        JPasswordField oldPass = new JPasswordField();
        JPasswordField newPass = new JPasswordField();
        JPasswordField rePass = new JPasswordField();

        Object[] message = { "Old Password: ", oldPass,
                             "New Password: ", newPass,
                             "Re-enter Password: ", rePass};

        int option = JOptionPane.showConfirmDialog(null, message, "Change Password", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (!MainPanelController.getProfileController().checkPassword(new String(oldPass.getPassword()))) { Dialogs.getPasswordNotCorrectWarning(); }
            else if (Arrays.equals(rePass.getPassword(), newPass.getPassword())) {
                MainPanelController.getProfileController().changePassword(new String(newPass.getPassword()));
                MainPanelController.getProfileController().saveProfiles();
                YoloTrader.logger.info("Changed password");

            } else { YoloTrader.logger.info("Changing password failed"); }
        } else { YoloTrader.logger.info("Changing password cancelled"); }
    }

    /**
     * dialog opens with the user's first, last, username, and email feilds.
     * If the email field is changed, it goes to check a valid email and then send code to validate
     * email if it is valid. If either of these fail, it displays warning.
     * It grabs the input of the first 3 feilds mentioned whether or not they change and changes them.
     */
    public static void getEditProfileDialog() {
        JTextField first = new JTextField(MainPanelController.getProfileController().getProfile().getFirst());
        JTextField last = new JTextField(MainPanelController.getProfileController().getProfile().getLast());
        JTextField user = new JTextField(MainPanelController.getProfileController().getProfile().getUsername());
        JTextField email = new JTextField(MainPanelController.getProfileController().getProfile().getEmail());

        Object[] message = {    "First Name: ", first, "Last Name: ", last,
                                "Username: ", user, "Email: ", email};

        int option = JOptionPane.showConfirmDialog(null, message, "Edit Profile", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String emailStr = MainPanelController.getProfileController().getProfile().getEmail();

            if (!MainPanelController.getProfileController().getProfile().getEmail().equals(email.getText())) {
                if (!EmailValidator.getInstance().isValid(email.getText())) { Email.getEmailNotValidWarning(); }
                else if (MainPanelController.getProfileController().isNotEmailUnique(email.getText())) { Email.getEmailWarning(); }
                else if (!Email.getEmailSentCodeValidation(email.getText())) { Email.getEmailValidationCodeNotValid(); }
                else { emailStr = email.getText(); }
            }

            MainPanelController.getProfileController().changeProfileFields(first.getText(), last.getText(), user.getText(), emailStr);
            ProfileSection.updateProfileLabels(first.getText(), last.getText(), user.getText(), emailStr);
            Name.updateLabelPanel(user.getText());

        } else { YoloTrader.logger.info("Editing profile cancelled"); }
    }
}
