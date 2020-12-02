package edu.baylor.ecs.csi3471.main;

import edu.baylor.ecs.csi3471.api.StockUtil;
import edu.baylor.ecs.csi3471.presentation.ui.mainPage.MainPanel;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * This is the main application starter87
 *
 * @author owenmurphy & Prince Kalu
 */
public class YoloTrader {

    public static Logger logger = Logger.getLogger(YoloTrader.class.getName());

    static {
        try {
            InputStream configFile = YoloTrader.class.getClassLoader().getResourceAsStream("logger.properties");
            LogManager.getLogManager().readConfiguration(configFile);
            assert configFile != null;
            configFile.close();
            StockUtil.updateAI();
        } catch (IOException ex) {
            System.out.println("WARNING: Could not open configuration file");
            System.out.println("WARNING: Logging not configured (console output only)");
        }
        logger.info("starting the app");
    }

    public static void main(String[] args) { MainPanel.getStartFrame(); }
}
