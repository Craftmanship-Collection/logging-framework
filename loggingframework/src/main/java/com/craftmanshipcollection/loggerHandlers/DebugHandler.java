package com.craftmanshipcollection.loggerHandlers;

import com.craftmanshipcollection.LogLevel;
import com.craftmanshipcollection.constants.LoggerPrefix;
import com.craftmanshipcollection.contexts.LoggerContext;

public class DebugHandler extends AbstractLogHandler {

    private static final String loggerPrefix = LoggerPrefix.DEBUGLOGGERPREFIX;
    private static final LogLevel logLevel = LogLevel.DEBUG;

    public DebugHandler(LoggerContext loggerContext) {
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
