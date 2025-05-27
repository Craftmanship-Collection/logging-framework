package com.craftmanshipcollection.loggerHandlers;

import com.craftmanshipcollection.LogLevel;
import com.craftmanshipcollection.constants.LoggerPrefix;
import com.craftmanshipcollection.contexts.LoggerContext;

public class WarnHandler extends AbstractLogHandler {

    private static final String loggerPrefix = LoggerPrefix.WARNLOGGERPREFIX;
    private static final LogLevel logLevel = LogLevel.WARN;

    public WarnHandler(LoggerContext loggerContext) {
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
