package edu.baylor.ecs.csi3471.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(namespace = "Database")
public class DataBaseUtil {

    private String storageName;
    @XmlElementWrapper(name = "ProfileList")
    @XmlElement(name = "AProfile")
    private List<Profile> profileList;

    public DataBaseUtil() {
        profileList = new ArrayList<>();
    }

    public List<Profile> getProfileList() { return profileList; }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataBaseUtil that = (DataBaseUtil) o;
        return Objects.equals(storageName, that.storageName) &&
                Objects.equals(profileList, that.profileList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageName, profileList);
    }

    public void addProfile(Profile profile) {
        profileList.add(profile);
    }
}
