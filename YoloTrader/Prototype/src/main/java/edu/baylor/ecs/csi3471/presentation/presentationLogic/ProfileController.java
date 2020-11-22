package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.service.ProfileService;

/**
 * @author owenmurphy
 */
public class ProfileController {

    /** user's Profile they use */
    private Profile profile;

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

    public void saveProfiles() { service.saveProfiles(); }

    public Profile checkCredentials(String email, String pass) {
        return service.getProfile(email, pass);
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

    public boolean recoverPassword(String email) {
        return this.service.recoverPassword(email);
    }
}
