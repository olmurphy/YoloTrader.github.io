package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * @author owenmurphy
 */
public class MainPanelController {


    /**
     * This function handles saving all data to the database
     * @return WindowListener to listen when the application is exited
     */
    public static WindowListener getMainFrameListener() {

        return new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("closing window");

                FormController.getProfileController().saveProfiles();
            }
        };
    }

    public static ProfileController getProfileController() {
        return FormController.getProfileController();
    }

    public static void initializeAllPanels() {
        CenterPanelController.setAllCenterPanels();
    }
}
