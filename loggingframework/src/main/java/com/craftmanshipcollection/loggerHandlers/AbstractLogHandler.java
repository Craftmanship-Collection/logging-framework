package com.craftmanshipcollection.loggerHandlers;

import com.craftmanshipcollection.LogLevel;
import com.craftmanshipcollection.configuration.LoggerConfig;
import com.craftmanshipcollection.contexts.LoggerContext;

public abstract class AbstractLogHandler implements LoggerHandler {
    
    private LoggerContext loggerContext;

    public AbstractLogHandler(LoggerContext loggerContext) {
        this.loggerContext = loggerContext;
    }
    
    @Override
    public void log(String message) throws Exception{

        if(LoggerConfig.getLevel().ordinal() <= getLogLevel().ordinal()) {

            message = getLoggerPrefix() + " " + message;
            loggerContext.appendMessage(message);

        }

    }

    public abstract LogLevel getLogLevel();
    public abstract String getLoggerPrefix();

}
