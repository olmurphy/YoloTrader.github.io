package edu.baylor.ecs.csi3471.dao;

<<<<<<< HEAD
import edu.baylor.ecs.csi3471.UI.mainPage.west.subpanels.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileDAOImpl implements ProfileDAO {

    private static List<Profile> profiles = new ArrayList<>();

    @Override
    public int insertProfile(Profile profile) {
        profiles.add(profile);
        return 1;
=======
import edu.baylor.ecs.csi3471.model.Profile;

import java.util.Vector;

public class ProfileDAOImpl implements ProfileDAO {
    @Override
    public Vector<Profile> getAllProfiles() {
        // FIXME: need to override methods
        return null;
    }

    @Override
    public boolean updateProfile(Profile profile) {
        // FIXME: need to override methods
        return false;
    }

    @Override
    public boolean deleteProfile(Profile profile) {
        // FIXME: need to override methods
        return false;
    }

    @Override
    public boolean addProfile(Profile profile) {
        // FIXME: need to override methods
        return false;
>>>>>>> 19bc821fff92c20d6c47c13dd6cabe46f05b90e5
    }
}
