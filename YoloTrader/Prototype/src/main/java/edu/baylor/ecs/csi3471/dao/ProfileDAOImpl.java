package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.UI.mainPage.west.subpanels.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileDAOImpl implements ProfileDAO {

    private static List<Profile> profiles = new ArrayList<>();

    @Override
    public int insertProfile(Profile profile) {
        profiles.add(profile);
        return 1;
    }
}
