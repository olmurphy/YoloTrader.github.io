package edu.baylor.ecs.csi3471.main;

import edu.baylor.ecs.csi3471.UI.form.FormController;
import edu.baylor.ecs.csi3471.UI.mainPage.MainPanel;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class YoloTrader {

    public static Logger logger = Logger.getLogger(YoloTrader.class.getName());

    static {
        try {
            InputStream configFile = YoloTrader.class.getClassLoader().getResourceAsStream("logger.properties");
            LogManager.getLogManager().readConfiguration(configFile);
            assert configFile != null;
            configFile.close();
        } catch (IOException ex) {
            System.out.println("WARNING: Could not open configuration file");
            System.out.println("WARNING: Logging not configured (console output only)");
        }
        logger.info("starting the app");
    }

    public static void main(String[] args) {
        // MainPanel.createUI("Owen");
        MainPanel.getStartFrame();
    }
}
