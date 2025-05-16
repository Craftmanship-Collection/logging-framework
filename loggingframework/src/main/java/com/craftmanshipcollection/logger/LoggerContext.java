package com.craftmanshipcollection.logger;

import java.util.List;
import java.util.concurrent.ExecutorService;

import com.craftmanshipcollection.appenders.LoggerAppender;
import com.craftmanshipcollection.utils.ExecutorServiceUtils;

public class LoggerContext {
    
    private ExecutorService executorService;
    private List<LoggerAppender> appenders;


    public static LoggerContext getLoggerContext(List<LoggerAppender> appenders, ExecutorService executorService) {

        LoggerContext context = LoggerContextHolder.INSTANCE;
        context.appenders = appenders;
        context.executorService = executorService;

        return context;

    }

    private LoggerContext() {

    }

    // public LoggerContext(
    //     ExecutorService executorService,
    //     List<LoggerAppender> appenders
    // ) {

    //     this.executorService = executorService;
    //     this.appenders = appenders;

    // }

    public void log(String message) {

        for(LoggerAppender appender: appenders) {
            
            executorService.submit(() -> appender.addTaskToAppender(message));

        }

    }

    public void addAppenders(LoggerAppender loggerAppender) {

        appenders.add(loggerAppender);
        
    }

    public void removeAppenders(LoggerAppender loggerAppender) {

        appenders.remove(loggerAppender);

    }

    private static class LoggerContextHolder {

        private static final LoggerContext INSTANCE = new LoggerContext();

    }

    void shutdown() {

        ExecutorServiceUtils.shutDown(executorService);
        appenders.forEach(appender -> appender.removeConnection());

    }
}
