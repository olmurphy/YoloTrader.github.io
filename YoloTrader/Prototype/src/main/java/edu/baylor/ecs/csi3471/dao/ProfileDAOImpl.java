package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.util.XMLProfileDAOUtil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author owenmurphy
 */
@XmlRootElement(namespace = "Database")
public class ProfileDAOImpl implements ProfileDAO {

    @XmlElementWrapper(name = "ProfileList")
    @XmlElement(name = "Profile")
    private List<Profile> profiles;

    /** class is used for XML file transformations */
    private static XMLProfileDAOUtil profileDAOUtil;

    public ProfileDAOImpl() {
        this.profiles = new ArrayList<>();
    }

    @Override
    public int insertProfile(Profile profile) {
        profiles.add(profile);
        profiles.forEach(x -> System.out.println(x.toString()));
        return 1;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profiles;
    }

    @Override
    public void setProfile(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public void loadProfiles() {
        profileDAOUtil = new XMLProfileDAOUtil();

        ProfileDAO dao;

        dao = profileDAOUtil.load();

        this.profiles = dao.getAllProfiles();
    }

    @Override
    public void saveProfiles() {
        profileDAOUtil = new XMLProfileDAOUtil();

        profileDAOUtil.doSave(this);
    }

    @Override
    public void changeProfilePassword(int index, String newPass) {
        this.profiles.get(index).setPassword(newPass);
        profiles.forEach(x -> System.out.println(x.toString()));
    }
}