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

    public void save(int index, Profile profile) {
        System.out.println("Updating the profile");
        // System.out.println(profile.toString());
        profiles.set(index, profile);
        profiles.forEach(System.out::println);
    }

    @Override
    public void save(Profile profile) {
        // do nothing
    }

    @Override
    public void update(Profile profile) {
        // don't do anything
    }

    @Override
    public void delete(Profile profile) {
        profiles.remove(profile);
    }

    @Override
    public boolean add(Profile profile) {
        System.out.println("adding profile");
        return profiles.add(profile);
    }

    @Override
    public void setAll(List<Profile> t) {
        profiles = t;
    }

    @Override
    public void loadAll() {
        profileDAOUtil = new XMLProfileDAOUtil();

        GenericDAO<Profile> dao;

        dao = profileDAOUtil.load();

        profiles = dao.getAll();
    }

    @Override
    public void saveAll() {
        // FIXME: Bug, I don't know what is going on
        System.out.println("--------Inside DAO saving...---------");
        profiles.forEach(System.out::println);
        System.out.println("----------------------\n\n");

        profileDAOUtil = new XMLProfileDAOUtil();

        profileDAOUtil.doSave(this);
    }

    public void changeProfilePassword(int index, String newPass) {
        profiles.get(index).setPassword(newPass);
        profiles.forEach(x -> System.out.println(x.toString()));
    }
}