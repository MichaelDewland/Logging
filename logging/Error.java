package logging;

/**
 * The Error class should be used when a method call returns a fatal exception.
 *
 * @author Michael Dewland
 * @version 1.0.1
 */
public class Error extends Log {

    /**
     * A constructor which takes a process and an error message.
     *
     * @param process The process from which the error originated
     * @param message The message displayed to the user
     */
    public Error(String process, String message) {
        super(process, message);
    }

    /**
     * A constructor which takes an exception, a process and an error message.
     *
     * @param thrownException The exception thrown by the offending method
     * @param process The process from which the * originated
     * @param message The message displayed to the user
     */
    public Error(Exception thrownException, String process, String message) {
        super(thrownException, process, message);
    }

    /**
     * The toString method for displaying an Error.
     *
     * @return The string display of the Error
     */
    @Override
    public String toString() {
        return "[" + dateTimeFormatter.format(time) + "]\t[ERROR] "
                + "\t[" + process + "]"
                + ((thrownException != null) ? " [Exception: \"" + thrownException.getClass().getName() + "\"]" : "")
                + " - "  + message ;
    }

}
