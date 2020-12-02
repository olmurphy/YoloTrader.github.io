package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.main.YoloTrader;
import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.util.XMLProfileDAOUtil;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * this class handles the adding/deleting/updating a profile in list of profiles
 * @author owenmurphy
 */
@XmlRootElement(namespace = "Database")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileDAO implements GenericDAO<Profile> {

    /** list of profiles to handle */
    @XmlElementWrapper(name = "profileList")
    @XmlElement(name = "profile")
    private static List<Profile> profiles;

    /** class is used for XML file transformations */
    private static XMLProfileDAOUtil profileDAOUtil;

    /** constructor declares an instance of profiles */
    public ProfileDAO() { profiles = new ArrayList<>(); }

    /**
     * @return list of profiles
     */
    @Override
    public List<Profile> getAll() { return profiles; }

    /**
     * sets the list of profiles to the parameter passed in
     * @param t list of items
     */
    @Override
    public void setAll(List<Profile> t) { profiles = t; }

    /**
     * add the profile into the list of profiles
     * @param t item to be added
     */
    @Override
    public void add(Profile t) { profiles.add(t); }

    /**
     * deletes the profile from the list of profiles
     * @param t item to be deleted
     */
    @Override
    public void delete(Profile t) { profiles.remove(t); }

    /**
     * updates the profiles in the list of profiles at the provided index
     * @param index index of item
     * @param t item to be updated
     */
    @Override
    public void update(int index, Profile t) { profiles.set(index, t); }

    /**
     * calls ${@link XMLProfileDAOUtil#load()} to load the items into the 
     * this.dao
     */
    public void loadAll() {
        profileDAOUtil = new XMLProfileDAOUtil();

        GenericDAO<Profile> dao;

        dao = profileDAOUtil.load();

        profiles = dao.getAll();
    }

    /**
     * calls the ${@link XMLProfileDAOUtil#doSave(GenericDAO)} to save all the profiles in the database
     */
    public void saveAll() {
        YoloTrader.logger.info("Saving into Database");
        profileDAOUtil = new XMLProfileDAOUtil();

        profileDAOUtil.doSave(this);
    }

    /**
     * changes password of the profiles at index
     * @param index index of profile to change password
     * @param newPass new password of profile
     */
    public void changeProfilePassword(int index, String newPass) { profiles.get(index).setPassword(newPass); }
}