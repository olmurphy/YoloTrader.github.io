package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.presentation.UI.form.Email;

import java.util.List;

/**
 * @author owenmurphy
 */
public class ProfileService {

    private GenericDAO<Profile> dao;

    public ProfileService() {
        this.dao = new ProfileDAO();
    }

    public ProfileService(GenericDAO<Profile> dao) {
        this.dao = dao;
    }

    public boolean addProfile(Profile profile) {

        List<Profile> profiles = this.dao.getAll();

        boolean isUnique = true;
        for (int i = 0; isUnique && i < profiles.size(); i++) { // short circuit the loop if found
            if (profiles.get(i).equals(profile)) {
                isUnique = false;
            }
        }

        if (isUnique) {
            this.dao.add(profile);
        }

        return isUnique;
    }

    public Object[] getProfile(String email, String pass) {
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

    public void saveProfiles() {
        dao.saveAll(); }

    public void save(int index, Profile profile) { ((ProfileDAO)this.dao).save(index, profile); }

    /**
     * @return GenericDAO of profiles for all profiles
     */
    public GenericDAO<Profile> getDao() {
        return dao;
    }

    /**
     * sets dao to param passed in
     *
     * @param dao ProfileDAO using
     */
    public void setDao(GenericDAO<Profile> dao) {
        this.dao = dao;
    }

    public void loadProfiles() {
        dao.loadAll();
    }

    public boolean recoverPassword(String email) {
        List<Profile> profiles = this.dao.getAll();

        boolean found = false;
        int index;
        for (index = 0; index < profiles.size() && !found; index++ ) {
            if (profiles.get(index).getEmail().equals(email)) {

                // email is associated with a profile, change password
                found = true;

                // changing password with a random password
                YoloTrader.logger.info("Changing password");
                String password = Email.getSaltString();
                ((ProfileDAO)this.dao).changeProfilePassword(index, password);

                // sending client new password
                Email.sendEmail(email, "Changed Password", "Your new password is: " +
                        password);
            }
        }

        return found;
    }
}