package com.craftmanshipcollection.logger;

public class LoggerConfiguration {

    private static LogLevel loggerLogLevel;
    
    public static void setLoggerLogLevel(String level) {

        loggerLogLevel = LogLevel.valueOf(level);

    }

    public static LogLevel getLogLevel() {

        return loggerLogLevel;

    }


}
