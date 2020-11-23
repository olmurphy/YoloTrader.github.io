package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.Thread;

import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;

public class SaveAllThread extends Thread {

    long identifier = 1;
    public RunThread runThread;

    public SaveAllThread(RunThread runThread) {
        this.runThread = runThread;
    }

    public void doSave() {
        this.runThread.print(this);
    }

    @Override
    public long getId() {
        return this.identifier;
    }

    @Override
    public String toString() {
        FormController.getProfileController().saveProfiles();
        System.out.println("saveAll...");
        return null;
    }
}
