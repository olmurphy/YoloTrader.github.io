package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.pages;

import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.form.Email;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanelController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.ProfileSection;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.heading.search.Name;
import org.apache.commons.validator.routines.EmailValidator;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author owenmurphy
 */
public class Dialogs {

    public static String watchListNameWindow() { return JOptionPane.showInputDialog("Enter watch list name:"); }

    public static void getWatchListNameTaken() {
        JOptionPane.showMessageDialog(null, "Name Taken",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * displays warning if the user has not selected watch list to perform an action on
     */
    public static void getNoWatchListSelectedWarning() {
        JOptionPane.showMessageDialog(null, "Need to select a watchList to add to",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void getNoStockSelectedWarning() {
        JOptionPane.showMessageDialog(null, "No stock is selected to delete",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static String getAddStockInputDialog() {
        return JOptionPane.showInputDialog(null, "Enter stock name to search",
                "Add Stock", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * pops up an input dialog asking the user for the password of the account to delete
     * @return user input for the password of the account
     */
    public static String getPassWordDialog() { return JOptionPane.showInputDialog(null, "Enter Password"); }

    /**
     * display to the user that the password passed in was incorrect
     */
    public static void getPasswordNotCorrectWarning() {
        JOptionPane.showMessageDialog(null, "password was incorrect", "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * opens a dialog for the user to change their password to their account
     */
    public static void getChangePassDialog() {
        JPasswordField oldPass = new JPasswordField();
        JPasswordField newPass = new JPasswordField();
        JPasswordField rePass = new JPasswordField();

        Object[] message = {    "Old Password: ", oldPass,
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

    public static void getEditProfileDialog() {
        JTextField first = new JTextField(MainPanelController.getProfileController().getProfile().getFirst());
        JTextField last = new JTextField(MainPanelController.getProfileController().getProfile().getLast());
        JTextField user = new JTextField(MainPanelController.getProfileController().getProfile().getUsername());
        JTextField email = new JTextField(MainPanelController.getProfileController().getProfile().getEmail());

        Object[] message = {    "First Name: ", first,
                                "Last Name: ", last,
                                "Username: ", user,
                                "Email: ", email};

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
