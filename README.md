# Logging

## Introduction

This document provides an overview of the custom logger implemented in Java. The logger supports logging of information, warnings, and errors. It initializes a `Logger` instance using `LoggerManager.getLogger(<classname>)` to handle all logging operations.

## Usage

An example usage file is contained in the package `logging.example`.

### Initialization

To use the logger, you need to initialize an instance of `Logger` using the `LoggerManager`. Import the necessary classes:



### Info
To log information to the console, call the `info` method of your logger instance.
The `info` method takes a single `String` parameter `info`.


### Warn
To log a warning to the console, call the `warn` method of your logger instance.
The `warn` method takes either a single `String` parameter `warning`, or two paramaters: an instance of `Exception` or any child-classes of its and a `String` `warning`.

### Error
To log an error to the console, call the `error` method of your logger instance.
The `error` method takes two paramaters: an instance of the `Exception` or any child-classes of its and a `String` `error`.

# Example
```java
import logging.Logger;
import logging.LoggerManager;

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
```

# Example output
```
Logs:
====
 - [2024/02/05 06:10:35]	[INFO] 		[logging.example.ExampleLogging] - Hello, welcome to the logger!
 - [2024/02/05 06:10:35]	[INFO] 		[logging.example.ExampleLogging] - Time to throw some warnings!
 - [2024/02/05 06:10:35]	[WARNING] 	[logging.example.ExampleLogging] - Age doesn't meet requirements!
 - [2024/02/05 06:10:35]	[WARNING] 	[logging.example.ExampleLogging] [Exception: "java.lang.NumberFormatException"] - Number failed to parse, may cause an issue later
 - [2024/02/05 06:10:35]	[ERROR] 	[logging.example.ExampleLogging] [Exception: "java.lang.NumberFormatException"] - Number failed to parse
```
