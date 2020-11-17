package edu.baylor.ecs.csi3471.main;

import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.dao.ProfileDAOImpl;
import edu.baylor.ecs.csi3471.model.*;
import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;
import edu.baylor.ecs.csi3471.presentation.presentationLogic.ProfileController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
        //MainPanel.getStartFrame();

        Profile profile = new Profile("email", "user", "pass", "first", "last");
        Profile profile1 = new Profile("email1", "user1", "pass1", "first1", "last1");

        Comment comment = new Comment();
        comment.setSubject("Concern");
        comment.setText("ok this is text");
        comment.setDateCreated(new Date());
        Stock stock = new Stock("Did", "Dillard", new Date());
        stock.addComment(comment);
        StockWatchList stw = new StockWatchList("Clothing Companies", new Date());
        stw.addStock(stock);

        profile.addWatchList(stw);
        profile1.addWatchList(stw);

        ProfileDAO dao = new ProfileDAOImpl();

        DataBaseUtil db = new DataBaseUtil();
        db.addProfile(profile);
        db.addProfile(profile1);
        db.setStorageName("YoloTrader");
        dao.doSave(db);
    }
}
