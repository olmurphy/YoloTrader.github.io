package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.Thread;

import edu.baylor.ecs.csi3471.presentation.UI.form.FormController;

public class SaveThread extends Thread {

    long identifier = 0;
    RunThread runThread;

    public SaveThread(RunThread runThread) {
        this.runThread = runThread;
    }


    public synchronized void run() {
        runThread.print(this);
    }

    @Override
    public long getId() {
        return this.identifier;
    }

    @Override
    public String toString() {
        FormController.getProfileController().save();
        System.out.println("save...");
        return null;
    }
}
