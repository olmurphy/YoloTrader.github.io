package edu.baylor.ecs.csi3471.presentation.UI.form;

import javax.swing.*;

public class Email {

    public static void getEmailWarning() {
        JOptionPane.showMessageDialog(null, "Unique email is required",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

}
