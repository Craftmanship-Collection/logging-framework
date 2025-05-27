package com.craftmanshipcollection.loggerHandlers;

import com.craftmanshipcollection.contexts.LoggerContext;
import com.craftmanshipcollection.LogLevel;
import com.craftmanshipcollection.constants.LoggerPrefix;

public class FatalHandler extends AbstractLogHandler {

    private static final String loggerPrefix = LoggerPrefix.FATALLOGGERPREFIX;
    private static final LogLevel logLevel = LogLevel.FATAL;

    public FatalHandler(LoggerContext loggerContext) {
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
