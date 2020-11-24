package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.service.ProfileService;

/**
 * @author owenmurphy
 */
public class ProfileController {

    /** user's Profile they use */
    private Profile profile;

    /** contains position that profile was found save it back in DAO */
    int profileIndex;

    /** Profile Service, the user is accessing the methods*/
    private ProfileService service;

    public ProfileController(Profile profile) {
        this.profile = profile;

        this.service = new ProfileService();
    }

    public boolean addProfile(Profile profile) {
        return service.addProfile(profile);
    }

    public void loadProfiles() { service.loadProfiles(); }

    public void saveProfiles() {
        service.saveProfiles();
    }

    public void save() {
        service.save(profileIndex, this.profile);
    }

    public boolean checkCredentials(String email, String pass) {

        Object[] objects = service.getProfile(email, pass);

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
     * @return index that profile was found at
     */
    public Integer getProfileIndex() {
        return profileIndex;
    }
}
