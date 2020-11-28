package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.service.ProfileService;

/**
 * class defines the method that the user is able to user
 * @author owenmurphy
 */
public class ProfileController {

    /** user's Profile they use */
    private Profile profile;

    /** contains position that profile was found save it back in DAO */
    int profileIndex;

    /** Profile Service, the user is accessing the methods*/
    private ProfileService service;

    /**
     * public constructor to set the profile and initialize a new profile service
     * @param profile profile to be set to
     */
    public ProfileController(Profile profile) {
        this.profile = profile;

        this.service = new ProfileService();
    }

    /**
     * calls ${@link ProfileService#addProfile(Profile)} to add the profile to the profile list
     * @param profile profile to add to the list
     */
    public void addProfile(Profile profile) {
        service.addProfile(profile);
    }

    /**
     * checks that the password passed in is same as password of profile, if so it calls
     * ${@link ProfileService#deleteProfile(Profile)} to delete this.profile
     * @param pass password to check in the profile to confirm
     * @return true if the profile was delete, false o.w.
     */
    public boolean deleteProfile(String pass) {
        if (profile.getPassword().equals(pass)) {
            service.deleteProfile(this.profile);
            this.saveProfiles();
            return true;
        } else {
            return false;
        }
    }

    /**
     * calls ${@link ProfileService#save(int, Profile)} to save the profile at the index
     */
    public void save() {
        service.save(profileIndex, this.profile);
    }

    /**
     * calls the ${@link ProfileService#findProfile(String, String)} to get the profile and the index
     * that it was found at. If the returned object is not null, then the profile is set
     * to the 2nd pos of the object array and the index to the 1st pos
     * @param email email of user input to check
     * @param pass password of user input to check
     * @return true if the user profile was set, false o.w.
     */
    public boolean checkCredentials(String email, String pass) {

        Object[] objects = service.findProfile(email, pass);

        if (objects[0] != null) {
            this.profileIndex = Integer.parseInt(objects[0].toString());
            this.profile = (Profile)objects[1]; // this works
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the Profile object
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * set Profile to parameter
     *
     * @param profile Profile object of controller
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * @return return the ProfileService
     */
    public ProfileService getService() {
        return service;
    }

    /**
     * set the ProfileService to param
     *
     * @param service ProfileService to be set to
     */
    public void setService(ProfileService service) {
        this.service = service;
    }

    /**
     * calls the service to inject the forgot password functionality
     * @param email email of the user to check if exists
     * @return true if password changed and email sent, o.w. false
     */
    public boolean recoverPassword(String email) {
        return this.service.recoverPassword(email);
    }

    /**
     * calls ${@link ProfileService#isEmailUnique(String)} to check if the
     * email passed in is indeed a unique email
     * @param email email to be checked if unique
     * @return true if email is unique, false o.w.
     */
    public boolean isEmailUnique(String email) {
        return this.service.isEmailUnique(email);
    }

    /**
     * calls ${@link ProfileService#loadProfiles()} to load all the profiles when the application
     * start
     */
    public void loadProfiles() { service.loadProfiles(); }

    /**
     * calls ${@link ProfileService#saveProfiles()} to save the profile to the database whenever a change is made
     */
    public void saveProfiles() {
        service.saveProfiles();
    }
}
