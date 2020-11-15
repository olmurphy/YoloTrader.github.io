package edu.baylor.ecs.csi3471.dao;

<<<<<<< HEAD
import edu.baylor.ecs.csi3471.UI.mainPage.west.subpanels.Profile;


public interface ProfileDAO {

    // FIXME: might need to add profile id
    int insertProfile(Profile profile);

    default int addProfile(Profile profile) {
        return insertProfile(profile);
    }
=======
import edu.baylor.ecs.csi3471.model.Profile;

import java.util.Vector;

public interface ProfileDAO {

    Vector<Profile> getAllProfiles();
    boolean updateProfile(Profile profile);
    boolean deleteProfile(Profile profile);
    boolean addProfile(Profile profile);
>>>>>>> 19bc821fff92c20d6c47c13dd6cabe46f05b90e5
}
