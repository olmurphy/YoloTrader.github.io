package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.model.Profile;
import sun.security.validator.ValidatorException;

public class ProfileService {

    ProfileDAO dao;

    public void save(Profile profile) throws ValidatorException {

        // perform validation
        checkUnique(profile.getEmail());

        if (profile.getEmail() == null) {
            dao.addProfile(profile);
        } else {
            dao.updateProfile(profile);
        }
    }

    public static void checkUnique(String email) {

    }

    public ProfileDAO getDao() {
        return dao;
    }

    public void setDao(ProfileDAO dao) {
        this.dao = dao;
    }
}
