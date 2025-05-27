package com.craftmanshipcollection.contexts;

import java.util.ArrayList;
import java.util.List;
import com.craftmanshipcollection.appenders.LoggerAppender;

public class LoggerContext {
    
    private List<LoggerAppender> loggerAppenders;

    private LoggerContext() {
        this.loggerAppenders = new ArrayList<>();
    }

    public void appendMessage(String message) throws Exception{

        for(LoggerAppender appender: loggerAppenders) {
            appender.appendMessage(message);
        }

    }

    public void addAppender(LoggerAppender loggerAppender) {

        this.loggerAppenders.add(loggerAppender);

    }

    public void removeAppender(LoggerAppender appender) {

        this.loggerAppenders.remove(appender);

    }

    public void stop() {

        for(LoggerAppender appender: loggerAppenders) {
            appender.stop();
        }

    }

    public static LoggerContext getInstance() {

        LoggerContext context = LoggerContextHolder.INSTANCE;

        return context;

    }

    static class LoggerContextHolder {

        private static final LoggerContext INSTANCE = new LoggerContext();

    }

}

