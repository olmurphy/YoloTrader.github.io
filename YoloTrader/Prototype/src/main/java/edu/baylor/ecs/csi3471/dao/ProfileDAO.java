package edu.baylor.ecs.csi3471.dao;


import edu.baylor.ecs.csi3471.model.DataBaseUtil;
import edu.baylor.ecs.csi3471.model.Profile;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProfileDAO {

    int insertProfile(Profile profile);

    default int addProfile(Profile profile) {
        return insertProfile(profile);
    }

    List<Profile> getAllProfiles();

    DataBaseUtil load() throws FileNotFoundException;

    void doSave(DataBaseUtil db);

}