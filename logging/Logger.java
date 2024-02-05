package logging;

/**
 * The Logger class is an abstracted interface for LoggerManager that handles the passing of classnames and messages to the LoggerManager
 *
 * @author Michael Dewland
 * @version 1.0
 */

public class Logger {

    private String className;

    public Logger(String className) {
        this.className = className;
    }

    /**
     * Log some info.
     * @param info the info
     */
    public void info(String info) {
        LoggerManager.info(className, info);
    }

    /**
     * Log a warning.
     * @param warning the warning
     */
    public void warn(String warning) {
        LoggerManager.warn(className, warning);
    }

    /**
     * Log a warning.
     * @param thrownException the exception thrown
     * @param warning the warning
     */
    public void warn(Exception thrownException, String warning) {
        LoggerManager.warn(thrownException, className, warning);
    }


    /**
     * Log a fatal exception.
     * @param thrownException the exception thrown
     * @param errorMessage the error message
     */
    public void error(Exception thrownException, String errorMessage) {
        LoggerManager.error(thrownException, className, errorMessage);
    }


}
