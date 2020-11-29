package edu.baylor.ecs.csi3471.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is the user's profile that holds the user's information
 *
 * @author owenmurphy
 */
@XmlRootElement(name = "Profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {

    /** represents user's email */
    private String email;
    /** user's username that displays on profile page */
    private String username;
    /** used to login and keep account secure */
    private String password;
    /** first name of user */
    private String first;
    /** last name of user */
    private String last;

    /** ArrayList implementation is faster it seems */
    @XmlElementWrapper(name = "listOfWatchLists")
    @XmlElement(name = "watchListName")
    private List<StockWatchList> watchLists;

    public Profile() { }

    /**
     * default constructor for creating a Profile. creates Profile with
     * email, username, and password, first, last the essentials.
     *
     * @param email email user uses to retrieve password
     * @param username username the user wants to be seen as
     * @param password key to logging in
     * @param first first name of user
     * @param last last name of user
     */
    public Profile(String email, String username, String password, String first, String last) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.first = first;
        this.last = last;

        // users watchLists is empty upon creating an account
        this.watchLists = new ArrayList<>();
    }

    /**
     * @return returns email attribute
     */
    public String getEmail() { return email; }

    /**
     * sets email attribute of Profile
     *
     * @param email email of user
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * @return username of the users Profile
     */
    public String getUsername() { return username; }

    /**
     * sets the user's username
     *
     * @param username username of user
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * sets password of user's Profile
     *
     * @param password password user uses to login
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * @return users password
     */
    public String getPassword() { return password; }

    /**
     * @return first name of user
     */
    public String getFirst() { return first; }

    /**
     * sets first name of user
     *
     * @param first first name of user
     */
    public void setFirst(String first) { this.first = first; }

    /**
     * @return last name of user
     */
    public String getLast() { return last; }

    /**
     * sets last name attribute of user's Profile
     *
     * @param last last name of user
     */
    public void setLast(String last) { this.last = last; }

    /**
     * @return the stockWatchList
     */
    public List<StockWatchList> getWatchLists() { return watchLists; }

    /**
     * sets the stockWatchList of user's Profile
     *
     * @param watchLists user's list of watch lists
     */
    public void setWatchLists(List<StockWatchList> watchLists) { this.watchLists = watchLists; }

    @Override
    public String toString() {
        return "Profile{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", watchLists=" + watchLists +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(email, profile.email);
    }

    @Override
    public int hashCode() { return Objects.hash(email); }
}
