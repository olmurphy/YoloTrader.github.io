package edu.baylor.ecs.csi3471.presentation.UI.mainPage;

import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainPanelController {


    /**
     * This function handles saving all data to the database
     * @return
     */
    public static WindowAdapter getMainFrameAction() {
        return new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {

                FormController.getProfileController().getService().getDao().saveProfiles();
                super.windowLostFocus(e);
                System.out.println("lost focus");
            }
        };
    }
}
