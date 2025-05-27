package com.craftmanshipcollection.configuration;

import com.craftmanshipcollection.LogLevel;

public class LoggerConfig {

    private static LogLevel logLevel;

    public static void setLevel(String level) {
        logLevel = LogLevel.valueOf(level.toUpperCase());
    }

    public static LogLevel getLevel() {
        return logLevel;
    }
    
}
