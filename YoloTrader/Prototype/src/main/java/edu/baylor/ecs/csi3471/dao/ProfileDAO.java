package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.Profile;

import java.util.Vector;

public interface ProfileDAO {

    Vector<Profile> getAllProfiles();
    boolean updateProfile(Profile profile);
    boolean deleteProfile(Profile profile);
    boolean addProfile(Profile profile);
}
