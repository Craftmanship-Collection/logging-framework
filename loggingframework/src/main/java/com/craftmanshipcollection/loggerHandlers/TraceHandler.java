package com.craftmanshipcollection.loggerHandlers;

import com.craftmanshipcollection.LogLevel;
import com.craftmanshipcollection.constants.LoggerPrefix;
import com.craftmanshipcollection.contexts.LoggerContext;

public class TraceHandler extends AbstractLogHandler {

    private static final String loggerPrefix = LoggerPrefix.TRACELOGGERPREFIX;
    private static final LogLevel logLevel = LogLevel.TRACE;

    public TraceHandler(LoggerContext loggerContext) {
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
