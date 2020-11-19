package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.dao.ProfileDAOImpl;
import edu.baylor.ecs.csi3471.model.Profile;

import java.util.List;

public class ProfileService {

    private ProfileDAO dao;

    public ProfileService() {
        this.dao = new ProfileDAOImpl();
    }

    public ProfileService(ProfileDAO dao) {
        this.dao = dao;
    }

    public boolean addProfile(Profile profile) {

        List<Profile> profiles = dao.getAllProfiles();

        boolean uniqueEmail = true;

        for (int i = 0; uniqueEmail && i < profiles.size(); i++) {
            if (profiles.get(i).getEmail().equals(profile.getEmail())) {
                uniqueEmail = false;
            }
        }

        if (uniqueEmail) {
            dao.insertProfile(profile);
        }

        return uniqueEmail;
    }

    public Profile getProfile(String email, String pass) {
        Profile retProfile = null;

        List<Profile> profiles = dao.getAllProfiles();

        boolean found = false;
        for (int i = 0; !found && i < profiles.size(); i++) {
            if (email.equals(profiles.get(i).getEmail()) && pass.equals(profiles.get(i).getPassword())) {
                found = true;
                retProfile = profiles.get(i);
            }
        }

        return retProfile;
    }

    public void saveProfiles() { dao.saveProfiles(); }

    /**
     * @return ProfileDAO for all profiles
     */
    public ProfileDAO getDao() {
        return dao;
    }

    /**
     * sets dao to param passed in
     *
     * @param dao ProfileDAO using
     */
    public void setDao(ProfileDAO dao) {
        this.dao = dao;
    }

    public void loadProfiles() {
        dao.loadProfiles();
    }
}