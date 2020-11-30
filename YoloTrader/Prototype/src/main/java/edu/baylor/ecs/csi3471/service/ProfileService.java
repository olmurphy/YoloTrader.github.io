package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.form.Email;

import java.util.List;

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
    public void addProfile(Profile profile) {

        this.dao.add(profile);
    }

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
        Object[] objects = new Object[2];

        objects[0] = null;
        objects[1] = null;

        List<Profile> profiles = dao.getAll();
        boolean found = false;
        for (int index = 0; !found && index < profiles.size(); index++) {
            if (profiles.get(index).getEmail().equals(email) && profiles.get(index).getPassword().equals(pass)) {
                objects[0] = index;
                objects[1] = profiles.get(index);
                found = true;
            }
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

    public void changePassword(int index, String newPass) { ((ProfileDAO)this.dao).changeProfilePassword(index, newPass); }

    /**
     * this method takes in an email and sees if it exists in the database
     * if so it changes the password associated to the email and changes the email
     * @param email email of the user to check in database and potentially send email
     * @return true if email found and email sent, o.w. false
     */
    public boolean recoverPassword(String email) {
        List<Profile> profiles = this.dao.getAll();

        for (int index = 0; index < profiles.size(); index++ ) {
            if (profiles.get(index).getEmail().equals(email)) {

                // changing password with a random password
                YoloTrader.logger.info("Changing password");
                String password = Email.getRandomString();
                ((ProfileDAO)this.dao).changeProfilePassword(index, password);

                // sending client new password
                Email.sendEmail(email, "Changed Password", "Your new password is: " +
                        password);

                // email is associated with a profile
                return true;
            }
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

    public boolean isEmailUnique(String email) {
        for (Profile profile : this.getDao().getAll()) {
            if (profile.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}