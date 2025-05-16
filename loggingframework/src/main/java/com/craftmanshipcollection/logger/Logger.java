package com.craftmanshipcollection.logger;

import java.time.LocalDateTime;

public class Logger {
    
    private LogLevel logLevel;
    private LoggerContext loggerContext;

    // public Logger(
    //     LoggerContext loggerContext,
    //     LogLevel logLevel
    // ) {
    //     this.loggerContext = loggerContext;
    //     this.logLevel = logLevel;
    // }

    private Logger() {

    }

    public static Logger getInstance() {

        return LoggerHolder.INSTANCE;

    }

    public void debug(String message) {

        LocalDateTime now = LocalDateTime.now();

        if(logLevel.ordinal() <= LogLevel.DEBUG.ordinal()) {

            loggerContext.log( now + " [DEBUG]: " + message);

        }

    }

    public void info(String message) {

        LocalDateTime now = LocalDateTime.now();

        if(logLevel.ordinal() <= LogLevel.INFO.ordinal()) {

            loggerContext.log(now + " [INFO]: " + message);

        }
    }

    public void error(String message) {

        LocalDateTime now = LocalDateTime.now();

        if(logLevel.ordinal() <= LogLevel.INFO.ordinal()) {

            loggerContext.log(now + " [ERROR]: " + message);

        }

    }

    public void fatal(String message) {

        LocalDateTime now = LocalDateTime.now();

        if(logLevel.ordinal() <= LogLevel.FATAL.ordinal()) {

            loggerContext.log(now + " [FATAL]: " + message);

        }
        
    }

    public void trace(String message) {

        LocalDateTime now = LocalDateTime.now();

        if(logLevel.ordinal() <= LogLevel.TRACE.ordinal()) {

            loggerContext.log( now + " [TRACE]: " + message);

        }

    }

    public void warn(String message) {

        LocalDateTime now = LocalDateTime.now();

        if(logLevel.ordinal() <= LogLevel.WARN.ordinal()) {

            loggerContext.log(now + " [WARN]: " + message);

        }
    }

    public void setLoggerContext(LoggerContext loggerContext) {
        
        this.loggerContext = loggerContext;

    }

    public void setLoggingLevel(LogLevel logLevel) {

        this.logLevel = logLevel;

    }

    public void shutDown() {

        loggerContext.shutdown();

    }

    private static class LoggerHolder {

        private static final Logger INSTANCE = new Logger();

    }
}
