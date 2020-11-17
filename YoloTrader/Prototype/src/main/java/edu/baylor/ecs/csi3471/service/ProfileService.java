package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.model.Profile;

import java.io.FileNotFoundException;
import java.util.List;

public class ProfileService {

    private ProfileDAO dao;

    public ProfileService(ProfileDAO dao) {
        this.dao = dao;
    }

    public int addProfile(Profile profile) {
        return dao.insertProfile(profile);
    }

    public List<Profile> getAllProfiles() {
        return dao.getAllProfiles();
    }

    public void save(Profile profile) {

        // perform validation
        checkUnique(profile.getEmail());

        /*
        if (profile.getEmail() == null) {
            dao.addProfile(profile);
        } else {
            dao.updateProfile(profile);
        }*/
    }

    public static void checkUnique(String email) {

    }

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
        try {
            this.dao.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}