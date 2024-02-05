package logging;

/**
 * The Warning class should be used when a method call returns a non-fatal but useful exception.
 *
 * @author Michael Dewland
 * @version 1.0.1
 */
public class Warning extends Log {

    /**
     * A constructor which takes a process and a warning message.
     *
     * @param process The process from which the warning originated
     * @param message The message displayed to the user
     */
    public Warning(String process, String message) {
        super(process, message);
    }

    /**
     * A constructor which takes an exception, a process and a warning message.
     *
     * @param thrownException The exception thrown by the offending method
     * @param process The process from which the warning originated
     * @param message The message displayed to the user
     */
    public Warning(Exception thrownException, String process, String message) {
        super(thrownException, process, message);
    }

    /**
     * The toString method for displaying a Warning.
     *
     * @return The string display of the Warning
     */
    @Override
    public String toString() {
        return "[" + dateTimeFormatter.format(time) + "]\t[WARNING] "
                + "\t[" + process + "]"
                + ((thrownException != null) ? " [Exception: \"" + thrownException.getClass().getName() + "\"]" : "")
                + " - "  + message ;
    }
}
