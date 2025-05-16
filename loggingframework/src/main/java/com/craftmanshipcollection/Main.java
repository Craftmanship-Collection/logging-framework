package com.craftmanshipcollection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.craftmanshipcollection.appenders.FileAppender;
import com.craftmanshipcollection.appenders.LoggerAppender;
import com.craftmanshipcollection.logger.LogLevel;
import com.craftmanshipcollection.logger.Logger;
import com.craftmanshipcollection.logger.LoggerContext;

public class Main {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);

        List<LoggerAppender> loggerAppenders = new ArrayList<>();
    
        
        String filePath = "logs/";
        LoggerAppender fileAppender = new FileAppender(filePath, true);
        
        loggerAppenders.add(fileAppender);

        LoggerContext context = LoggerContext.getLoggerContext(loggerAppenders, service);
        Logger logger = Logger.getInstance();

        logger.setLoggerContext(context);
        logger.setLoggingLevel(LogLevel.DEBUG);

        System.out.println("Running something");
        System.out.println("Logger Enabled");
        System.out.println("Check " + filePath + " for logs");

        runSomething(logger);

        logger.shutDown();

        

    }

    public static void runSomething(Logger logger) {

        for(int i = 0; i <= 10; i++) {

            logger.debug("value is: " + i);

            if(i == 10) {

                logger.warn("value is: " + i);

            }

        }

    }
}