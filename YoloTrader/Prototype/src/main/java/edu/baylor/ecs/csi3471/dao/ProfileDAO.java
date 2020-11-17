package edu.baylor.ecs.csi3471.dao;


import edu.baylor.ecs.csi3471.model.Profile;

import java.util.List;

public interface ProfileDAO {

    int insertProfile(Profile profile);

    default int addProfile(Profile profile) {
        return insertProfile(profile);
    }

    List<Profile> getAllProfiles();

    void setProfile(List<Profile> profiles);

    void loadProfiles();

    void saveProfiles();

}