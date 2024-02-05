package logging.example;

import com.michael.tracker.logging.Logger;
import com.michael.tracker.logging.LoggerManager;

public class ExampleLogging {

    private static final Logger logger = LoggerManager.getLogger(ExampleLogging.class.getName());

    public static void main(String[] args) {

        logSomeInfo();

        logSomeWarnings();

        logSomeErrors();

    }

    private static void logSomeInfo() {

        logger.info("Hello, welcome to the logger!");
        logger.info("Time to throw some warnings!");
    }

    private static void logSomeWarnings() {

        int age = 17;

        if (age < 18) {
            logger.warn("Age doesn't meet requirements!");
        }

        try {
            int num = Integer.parseInt(String.valueOf("one"));
        } catch (NumberFormatException e) {
            logger.warn(e, "Number failed to parse, may cause an issue later");
        }

    }

    private static void logSomeErrors() {

        try {
            int num = Integer.parseInt(String.valueOf("one"));
        } catch (NumberFormatException e) {
            logger.error(e, "Number failed to parse");
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error(e, "Couldn't sleep, Thread waiting/sleeping");
        }
    }

}
