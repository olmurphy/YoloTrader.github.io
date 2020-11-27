package edu.baylor.ecs.csi3471.modelTest;

import edu.baylor.ecs.csi3471.model.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class test ${@link Profile} class and its various methods
 *
 * @author owenmurphy
 */
public class ProfileTest {

    Profile profile = null;
    Profile profile1 = null;

    @BeforeEach
    void init() {
        profile = new Profile();
        profile1 = new Profile();
    }

    @Test
    void insertProfile() {
        profile.setUsername("user");
        profile.setPassword("pass");
        profile.setEmail("email");
        profile.setFirst("first");
        profile.setLast("last");

        profile1 = new Profile();
        profile1.setEmail("email");

        // FIXME: assertEquals(profile, profile1, "Should be equal");
    }

    @Test
    void testUser() {
        profile.setUsername("user");
        profile1.setUsername("user");

        // FIXME: assertEquals(profile.getUsername(), profile1.getUsername(), "should be equal");
    }

    @Test
    void notSameUser() {
        profile.setUsername("user");
        profile1.setUsername("User");

        // FIXME: assertNotEquals(profile.getUsername(), profile1.getUsername(), "should NOT be equal");
    }

    @Test
    void testPass() {
        profile.setPassword("pass");
        profile1.setPassword("pass");

        // FIXME: assertEquals(profile.getPassword(), profile1.getPassword(), "should be equal");
    }

    @Test
    void notSamePass() {
        profile.setPassword("pass");
        profile1.setPassword("Pass");

        // FIXME: assertNotEquals(profile.getPassword(), profile1.getPassword(), "should NOT be equal");
    }

    @Test
    void testFirst() {
        profile.setFirst("first");
        profile1.setFirst("first");

        // FIXME: assertEquals(profile.getFirst(), profile1.getFirst(), "should be equal");
    }

    @Test
    void notSameFirst() {
        profile.setFirst("first");
        profile1.setFirst("First");

        // FIXME: assertNotEquals(profile.getFirst(), profile1.getFirst(), "should NOT be equal");
    }

    @Test
    void testLast() {
        profile.setLast("last");
        profile1.setLast("last");

        // FIXME: assertEquals(profile.getLast(), profile1.getLast(), "should be equal");
    }

    @Test
    void notSameLast() {
        profile.setLast("last");
        profile1.setLast("Last");

        // FIXME: assertNotEquals(profile.getLast(), profile1.getLast(), "should NOT be equal");
    }
}
