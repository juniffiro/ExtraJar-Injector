package ua.juniffiro.extrajar.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    public static final Logger logger = Logger.getLogger("Loader");

    public static void log(String message, Level level) {
        logger.log(level, message);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warning(message);
    }

    public static void error(String message) {
        logger.severe(message);
    }

    public static void log(Object object, Level level) {
        log(object.toString(), level);
    }

    public static void log(Level level, String message, Object... objects) {
        log(String.format(message, objects), level);
    }
}