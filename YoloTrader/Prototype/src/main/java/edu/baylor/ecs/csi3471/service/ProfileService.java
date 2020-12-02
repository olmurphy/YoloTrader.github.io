package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.form.Email;

/**
 * this class injects the functionality of the
 * ${@link edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController}
 *
 * @author owenmurphy
 */
public class ProfileService {

    /** Uses the dao to access the profile data */
    private GenericDAO<Profile> dao;

    /**
     * constructor initializes the dao
     */
    public ProfileService() { this.dao = new ProfileDAO(); }

    /**
     * iterates through all of the profiles checking that the profile passed in does
     * not match a profile in the list of profiles
     * @param profile profile to be added into the list of profiles
     */
    public void addProfile(Profile profile) { this.dao.add(profile); }

    /**
     * calls ${@link ProfileDAO#delete(Profile)} to delete the profile from the dao
     * @param profile profile to delete the profile from
     */
    public void deleteProfile(Profile profile) { this.dao.delete(profile); }

    /**
     * travers through the list of profiles looking for the email and password passed
     * in
     * @param email email of user to find
     * @param pass password of user to find
     * @return Object is a two-tuple, first position is the index & 2nd position is the
     * Profile instance, returns these two if the email & pass matched a profile in the
     * list of profile, else returns null indicating email and pass do not match
     */
    public Object[] findProfile(String email, String pass) {
        Object[] objects = {null, null};
        int index = 0;

        for (Profile profile : this.dao.getAll()) {
            if (profile.getEmail().equals(email) && profile.getPassword().equals(pass)) {
                objects[0] = index;
                objects[1] = profile;
                return objects;
            } else { index ++; }
        }
        return objects;
    }

    /**
     * @return GenericDAO of profiles for all profiles
     */
    public GenericDAO<Profile> getDao() { return dao; }

    /**
     * sets dao to param passed in
     *
     * @param dao ProfileDAO using
     */
    public void setDao(GenericDAO<Profile> dao) { this.dao = dao; }

    /**
     * calls ${@link ProfileDAO#update(int, Profile)} to save the profile in the dao
     * at the specified index
     * @param index index of profile in the list
     * @param profile profile to save in the profile list
     */
    public void save(int index, Profile profile) { this.dao.update(index, profile); }

    /**
     * changes the password at the given index in the dao
     * @param index index of the profile to change password
     * @param newPass new password to change to
     */
    public void changePassword(int index, String newPass) { ((ProfileDAO)this.dao).changeProfilePassword(index, newPass); }

    /**
     * this method takes in an email and sees if it exists in the database
     * if so it changes the password associated to the email and changes the email
     * @param email email of the user to check in database and potentially send email
     * @return true if email found and email sent, o.w. false
     */
    public boolean recoverPassword(String email) {
        int index = 0;

        for (Profile profile : this.dao.getAll()) {
            if (profile.getEmail().equals(email)) {
                YoloTrader.logger.info("Changing password");

                // changing password with a random password
                String password = Email.getRandomString();

                ((ProfileDAO)this.dao).changeProfilePassword(index, password);

                Email.sendEmail(email, "Changed Password", "Your new password is: " + password); // sending client new password

                return true; // email is associated with a profile
            } else { index++; }
        }
        return false;
    }

    /**
     * this method calls ${@link ProfileDAO#loadAll()} to load all profiles upon the application starting
     */
    public void loadProfiles() { ((ProfileDAO)dao).loadAll(); }

    /**
     * calls ${@link ProfileDAO#saveAll()} to save all the profiles into the database
     */
    public void saveProfiles() { ((ProfileDAO)dao).saveAll(); }

    /**
     * checks if the email passed in is found in the ${@link ProfileDAO}
     * @param email email to check in the DAO
     * @return true if the email passed in was not found (i.e. unique) false o.w.
     */
    public boolean isEmailUnique(String email) {
        return this.dao.getAll().stream().filter(x -> x.getEmail().equals(email)).findFirst().orElse(null) != null;
    }
}