package com.craftmanshipcollection.loggerHandlers;

import com.craftmanshipcollection.LogLevel;
import com.craftmanshipcollection.contexts.LoggerContext;
import com.craftmanshipcollection.constants.LoggerPrefix;

public class InfoHandler extends AbstractLogHandler {

    private static final String loggerPrefix = LoggerPrefix.INFOLOGGERPREFIX;
    private static final LogLevel logLevel = LogLevel.INFO;

    public InfoHandler(LoggerContext loggerContext) {
        super(loggerContext);
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public String getLoggerPrefix() {
        return loggerPrefix;
    }
    
}
