package logging;

import java.util.ArrayList;

/**
 * The Logger class keeps track of all warnings and logs submitted by parts of the code.
 * <p></p>
 * These logs may be displayed at the time they occur or at the end of application execution.
 *
 * @author Michael Dewland
 * @version 2.1
 */
public class LoggerManager {

    // The Fatals.
    private static final ArrayList<Error> errors = new ArrayList<>();

    // The Warnings.
    private static final ArrayList<Warning> warnings = new ArrayList<>();

    // The Logs.
    private static final ArrayList<Log> logs = new ArrayList<>();

    // Warnings and Logs combined.
    private static final ArrayList<Log> allLogs = new ArrayList<>();

    // Whether logs are displayed in the console as they are submitted.
    private static boolean doPrintLogs = true;

    // On application launch.
    static {
        System.out.println("\nLogs:");
        System.out.println("====\n");
    }

    /**
     * Log some info.
     * @param className the class giving info
     * @param info the info
     */
    public static void info(String className, String info) {
        submitLog(new Log(className, info));
    }

    /**
     * Log a warning.
     * @param className the class giving a warning
     * @param warning the warning
     */
    public static void warn(String className, String warning) {
        submitLog(new Warning(className, warning));
    }

    /**
     * Log a warning.
     * @param thrownException the exception thrown
     * @param className the class giving a warning
     * @param warning the warning
     */
    public static void warn(Exception thrownException, String className, String warning) {
        submitLog(new Warning(thrownException, className, warning));
    }

    /**
     * Log a fatal exception.
     * @param thrownException the exception thrown
     * @param className the class giving an exception
     * @param errorMessage the error message
     */
    public static void error(Exception thrownException, String className, String errorMessage) {
        submitLog(new Error(thrownException, className, errorMessage));
    }

    /**
     * A method for submitting a Log to the MasterLogger.
     * <p></p>This method will print logs unless disabled (MasterLogger.disableLogPrinting()).
     *
     * @param log The log being submitted
     */
    private static void submitLog(Log log) {

        if (doPrintLogs) {
            System.out.println(" - " + log);
        }

        allLogs.add(log);

        if (log instanceof Warning) {
            warnings.add((Warning) log);
        } else if (log instanceof Error) {
            errors.add((Error) log);
        } else {
            logs.add(log);
        }
    }

    /**
     * A method for printing all logs that have been submitted thus far.
     */
    public static void printLogs() {

        System.out.println("\nErrors:");
        System.out.println("========\n");

        for (Error error : errors) {
            System.out.println(" - " + error);
        }

        System.out.println("\nWarnings:");
        System.out.println("========\n");

        for (Warning warning : warnings) {
            System.out.println(" - " + warning);
        }

        System.out.println("\nGeneral Logs:");
        System.out.println("============\n");

        for (Log log : logs) {
            System.out.println(" - " + log);
        }

        System.out.println("\nAll Logs:");
        System.out.println("========\n");

        for (Log log : allLogs) {
            System.out.println(" - " + log);
        }
    }

    /**
     * A method that enables logs being printed to the console upon submission.
     */
    public static void enableLogPrinting() {
        LoggerManager.doPrintLogs = true;
    }

    /**
     * A method that disables logs being printed to the console upon submission.
     */
    public static void disableLogPrinting() {
        LoggerManager.doPrintLogs = false;
    }

    public static Logger getLogger(String name) {
        return new Logger(name);
    }
}
