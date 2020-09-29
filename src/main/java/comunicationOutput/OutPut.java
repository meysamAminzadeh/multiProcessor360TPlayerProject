package comunicationOutput;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * this is project's output and log every time you like to comunication with other players
 * @author Meysam Aminzadeh on 8/2/2020.
 */
public class OutPut {
    public static void write(String logText, String className) {
        Logger LOGGER = Logger.getLogger(className);
        try {
            File logDir = new File("./logs/");
            if (!(logDir.exists()))
                logDir.mkdir();

            FileHandler handler = new FileHandler(logDir + File.separator + "output.log", true);
            handler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(handler);
            LOGGER.info(logText);
            handler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
