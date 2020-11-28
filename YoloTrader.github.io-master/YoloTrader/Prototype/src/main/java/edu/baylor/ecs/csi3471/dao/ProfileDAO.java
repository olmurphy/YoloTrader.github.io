package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.util.XMLProfileDAOUtil;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author owenmurphy
 */
@XmlRootElement(namespace = "Database")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileDAO implements GenericDAO<Profile> {

    @XmlElementWrapper(name = "profileList")
    @XmlElement(name = "profile")
    private static List<Profile> profiles;

    /** class is used for XML file transformations */
    private static XMLProfileDAOUtil profileDAOUtil;

    public ProfileDAO() {
        profiles = new ArrayList<>();
    }

    @Override
    public List<Profile> getAll() {
        return profiles;
    }

    @Override
    public void setAll(List<Profile> t) {
        profiles = t;
    }
    
    @Override
    public void add(Profile profile) {
        profiles.add(profile);
    }
    
    @Override
    public void delete(Profile profile) {
        profiles.remove(profile);
    }

    @Override
    public void update(int index, Profile profile) {
        profiles.set(index, profile);
    }

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
        System.out.println("--------Inside DAO saving---------");
        profiles.forEach(System.out::println);
        System.out.println("----------------------------------\n\n");

        profileDAOUtil = new XMLProfileDAOUtil();

        profileDAOUtil.doSave(this);
    }

    /**
     * changes password of the profiles at index
     * @param index index of profile to change password
     * @param newPass new password of profile
     */
    public void changeProfilePassword(int index, String newPass) {
        profiles.get(index).setPassword(newPass);
    }
}