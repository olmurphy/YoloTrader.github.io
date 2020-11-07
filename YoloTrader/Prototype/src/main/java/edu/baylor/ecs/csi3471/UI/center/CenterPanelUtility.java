package edu.baylor.ecs.csi3471.UI.center;

import edu.baylor.ecs.csi3471.UI.MainPanel;
import edu.baylor.ecs.csi3471.UI.center.profile.ProfileSection;
import edu.baylor.ecs.csi3471.UI.heading.NorthPanelUtility;

import javax.swing.*;

public class CenterPanelUtility {

    public static int centerPanelHeight = MainPanel.frameHeight - NorthPanelUtility.northPanelHeight;

    public static JPanel getProfilePanel() {
        return ProfileSection.getProfilePanel();
    }

}
