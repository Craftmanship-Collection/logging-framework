import java.util.Scanner;

import CORPattern.ConcreteLogHandlers.*;
import CORPattern.LogHandler;
import LogAppenderStrategies.ConcreteLogAppenders.*;
import LogAppenderStrategies.LogAppender;
import CommonEnum.LogLevel;
import LoggerControllers.*;

public class Main {

    // Build the chain of loggers: INFO -> DEBUG -> ERROR
    private static LogHandler getChainOfLoggers(LogAppender appender) {
        LogHandler errorLogger = new ErrorLogger(LogHandler.ERROR, appender);
        LogHandler debugLogger = new DebugLogger(LogHandler.DEBUG, appender);
        LogHandler infoLogger = new InfoLogger(LogHandler.INFO, appender);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        return infoLogger;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LogAppender consoleAppender = new ConsoleAppender();
        LogAppender fileAppender = new FileAppender("logs.txt");

        while (true) {
            System.out.println("\nInteractive Logging Menu:");
            System.out.println("1. Configure Chain of Loggers");
            System.out.println("2. Use Singleton Logger");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    configureChainOfLoggers(scanner, consoleAppender, fileAppender);
                    break;
                case 2:
                    useSingletonLogger(scanner, consoleAppender, fileAppender);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void configureChainOfLoggers(Scanner scanner, LogAppender consoleAppender, LogAppender fileAppender) {
        System.out.println("Select log appender:");
        System.out.println("1. Console");
        System.out.println("2. File");
        System.out.print("Enter your choice: ");
        int appenderChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        LogAppender appender;
        switch (appenderChoice) {
            case 1:
                appender = consoleAppender;
                break;
            case 2:
                appender = fileAppender;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to console appender.");
                appender = consoleAppender;
        }

        LogHandler loggerChain = getChainOfLoggers(appender);

        System.out.println("Select log level:");
        System.out.println("1. INFO");
        System.out.println("2. DEBUG");
        System.out.println("3. ERROR");
        System.out.print("Enter your choice: ");
        int levelChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        String message = "";
        System.out.print("Enter your log message: ");
        message = scanner.nextLine();

        switch (levelChoice) {
            case 1:
                loggerChain.logMessage(LogHandler.INFO, message);
                break;
            case 2:
                loggerChain.logMessage(LogHandler.DEBUG, message);
                break;
            case 3:
                loggerChain.logMessage(LogHandler.ERROR, message);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void useSingletonLogger(Scanner scanner, LogAppender consoleAppender, LogAppender fileAppender) {
        System.out.println("Select log level:");
        System.out.println("1. INFO");
        System.out.println("2. DEBUG");
        System.out.println("3. ERROR");
        System.out.print("Enter your choice: ");
        int levelChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        LogLevel logLevel;
        switch (levelChoice) {
            case 1:
                logLevel = LogLevel.INFO;
                break;
            case 2:
                logLevel = LogLevel.DEBUG;
                break;
            case 3:
                logLevel = LogLevel.ERROR;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to INFO.");
                logLevel = LogLevel.INFO;
        }

        System.out.println("Select log appender:");
        System.out.println("1. Console");
        System.out.println("2. File");
        System.out.print("Enter your choice: ");
        int appenderChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        LogAppender appender;
        switch (appenderChoice) {
            case 1:
                appender = consoleAppender;
                break;
            case 2:
                appender = fileAppender;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to console appender.");
                appender = consoleAppender;
        }

        System.out.print("Enter your log message: ");
        String message = scanner.nextLine();

        // Get the singleton logger instance
        Logger logger = Logger.getInstance(logLevel, appender);
        logger.log(logLevel, message);
    }
}