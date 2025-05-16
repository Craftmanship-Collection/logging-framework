# Logging Framework

A simple, flexible, and extensible logging framework for Java applications with asynchronous logging capabilities.

## Features

* **Multiple Log Levels:** Support for ```DEBUG```, ```INFO```, ```TRACE```, ```WARN```, ```ERROR```, and ```FATAL``` log levels
* **Asynchronous Logging:** Non-blocking logging operations using Java's ExecutorService
* **Multiple Appenders:** Extensible appender system for different output destinations
* **File Logging:** Built-in file appender with daily log rotation
* **Thread Safety:** Synchronized operations for file writing
* **Singleton Pattern:** Efficient Logger and LoggerContext implementations

## Getting Started

* Prerequisites: Java 8 or higher
* Basic Usage
* Architecture

    1. Core Components
        * Logger: Main entry point for logging operations
        * LoggerContext: Manages appenders and handles log distribution
        * LogLevel: Enum defining log severity levels
        * LoggerAppender: Interface for different logging destinations
    2. Appenders
        * FileAppender: Writes logs to files with daily rotation
        * DatabaseAppender: (Example placeholder for database logging)
    3. Utilities
        * ExecutorServiceUtils: Helper methods for managing executor services

* Advanced Usage

    1. Adding Custom Appenders

        ```java
        /* 
            Implement the LoggerAppender 
            interface to create custom appenders
        */
        public class ConsoleAppender implements LoggerAppender {
            @Override
            public void addTaskToAppender(String message) {
                System.out.println(message);
            }
            
            @Override
            public void removeConnection() {
                // No resources to clean up
            }
        }
        ```

    2. Configuring Log Levels

        ```java
        // Set log level programmatically
        logger.setLoggingLevel(LogLevel.WARN);  // Only WARN and higher severity will be logged

        // Or using the configuration class
        LoggerConfiguration.setLoggerLogLevel("INFO");
        ```

* Thread Safety
  * The framework uses synchronized blocks for file writing operations and ExecutorService for asynchronous processing, making it safe for multi-threaded environments.

## TODO

[ ] Add unit test cases
[ ] Complete database appender implementation
[ ] Add more appender types (Console, Network, etc.)
[ ] Implement log message formatting with patterns
[ ] Add log filtering capabilities
[ ] Improve error handling and recovery mechanisms
[ ] Add configuration via properties file
[ ] Create documentation with examples