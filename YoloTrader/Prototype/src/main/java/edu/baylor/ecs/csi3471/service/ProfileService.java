package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.UI.mainPage.west.subpanels.Profile;
import edu.baylor.ecs.csi3471.dao.ProfileDAO;

public class ProfileService {

    private final ProfileDAO dao;

    public ProfileService(ProfileDAO dao) {
        this.dao = dao;
    }

    public int addPerson(Profile profile) {
        return dao.insertProfile(profile);
    }
}
