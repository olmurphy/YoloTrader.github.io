package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * @author owenmurphy
 */
public class MainPanelController {



    /**
     * This function handles saving all data to the database
     * @return WindowAdapter to listen when the application is exited
     */
    public static WindowAdapter getMainFrameAction() {
        return new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {

                FormController.getProfileController().saveProfiles();
                System.out.println("exiting the application");
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
