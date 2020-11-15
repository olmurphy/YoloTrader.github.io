package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.UI.mainPage.west.subpanels.Profile;


public interface ProfileDAO {

    // FIXME: might need to add profile id
    int insertProfile(Profile profile);

    default int addProfile(Profile profile) {
        return insertProfile(profile);
    }
}
