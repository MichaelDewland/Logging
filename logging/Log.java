package logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Log class should be used when a method call should give useful information such as the reloading of an object or asset, etc.
 *
 * @author Michael Dewland
 * @version 1.0.1
 */
public class Log {

    // The helpful message.
    public String message;

    // The process from which the log was submitted.
    public String process;

    // An exception that may have been thrown (by a Warning).
    public Exception thrownException;

    // The time at which the log is created.
    public LocalDateTime time;

    // The string formatter for the Log submission time.
    protected DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * A constructor which takes a process and an insightful message.
     *
     * @param process The process from which the log originated
     * @param message The message displayed to the user
     */
    public Log(String process, String message) {
        this(null, process, message);
    }

    /**
     * A constructor which takes an exception, a process and an error message.
     *
     * @param thrownException The exception thrown by the offending method
     * @param process The process from which the warning originated
     * @param message The message displayed to the user
     */
    public Log(Exception thrownException, String process, String message) {
        this.thrownException = thrownException;
        this.message = message;
        this.process = process;
        this.time = LocalDateTime.now();
    }

    /**
     * The toString method for displaying a Log.
     *
     * @return The string display of the Log
     */
    @Override
    public String toString() {
        return "[" + dateTimeFormatter.format(time) + "]\t[INFO] "
                + "\t\t[" + process + "] "
                + ((thrownException != null) ? " [Exception: \"" + thrownException.getClass().getName() + "\"]" : "")
                + "- "  + message ;
    }
}
