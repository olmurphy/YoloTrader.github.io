package edu.baylor.ecs.csi3471;

import java.io.IOException;
import java.util.logging.*;

public class MySetup {

    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static public void setup() throws IOException { // get the global logger to configure it

        Logger logger = Logger.getLogger(Window.class.getName());

        // suppress the logging output to the console
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();

        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        //logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("Logging.txt");
        formatterTxt = new SimpleFormatter(); // create a TXT formatter
        fileTxt.setFormatter(formatterTxt);

        logger.addHandler(fileTxt);
    }
}
