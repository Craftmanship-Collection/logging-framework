package com.craftmanshipcollection.loggerHandlers;

import com.craftmanshipcollection.LogLevel;
import com.craftmanshipcollection.constants.LoggerPrefix;
import com.craftmanshipcollection.contexts.LoggerContext;

public class ErrorHandler extends AbstractLogHandler {

    private static final String loggerPrefix = LoggerPrefix.ERRORLOGGERPREFIX;
    private static final LogLevel logLevel = LogLevel.ERROR;

    public ErrorHandler(LoggerContext loggerContext) {
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
