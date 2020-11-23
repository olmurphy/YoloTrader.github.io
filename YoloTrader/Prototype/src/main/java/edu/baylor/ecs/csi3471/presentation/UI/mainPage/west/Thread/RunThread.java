package edu.baylor.ecs.csi3471.presentation.UI.mainPage.west.Thread;

import edu.baylor.ecs.csi3471.main.YoloTrader;

public class RunThread {

    int identifier = 0;

    protected synchronized void print(Thread t) {

        while (identifier != t.getId()) {
            try {
                wait();
            } catch (InterruptedException e) {
                YoloTrader.logger.info(e.getLocalizedMessage());
            }
        }

        t.toString();
        identifier++;
        notifyAll();
    }

}
