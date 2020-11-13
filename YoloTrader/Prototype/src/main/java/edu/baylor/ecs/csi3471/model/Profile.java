package edu.baylor.ecs.csi3471.model;

import java.util.ArrayList;
import java.util.List;

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
    private List<StockWatchList> watchLists;

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
        watchLists = new ArrayList<>();
    }

    /**
     * @return returns email attribute
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets email attribute of Profile
     *
     * @param email email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return username of the users Profile
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets the user's username
     *
     * @param username username of user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * sets password of user's Profile
     *
     * @param password password user uses to login
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * checks if password passed in is same as Profile password
     *
     * @param password password user's enters to validate
     * @return true if password matches, false otherwise
     */
    public boolean isPassword(String password) {

        // if password is null, the function returns false
        return this.password.equals(password);
    }

    /**
     * @return first name of user
     */
    public String getFirst() {
        return first;
    }

    /**
     * sets first name of user
     *
     * @param first first name of user
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @return last name of user
     */
    public String getLast() {
        return last;
    }

    /**
     * sets last name attribute of user's Profile
     *
     * @param last last name of user
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * @return the stockWatchList
     */
    public List<StockWatchList> getWatchLists() {
        return watchLists;
    }

    /**
     * sets the stockWatchList of user's Profile
     *
     * @param watchLists user's list of watch lists
     */
    public void setWatchLists(List<StockWatchList> watchLists) {
        this.watchLists = watchLists;
    }
}
