package com.craftmanshipcollection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;

import com.craftmanshipcollection.appenders.DatabaseAppender;
import com.craftmanshipcollection.appenders.FileAppender;
import com.craftmanshipcollection.configuration.LoggerConfig;
import com.craftmanshipcollection.contexts.LoggerContext;
import com.craftmanshipcollection.daos.LogDao;
import com.craftmanshipcollection.loggers.Logger;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        LoggerConfig.setLevel("debug");
        FileAppender fileAppender = new FileAppender(new ArrayBlockingQueue<>(5), Executors.newFixedThreadPool(2), "logs/");

        LogDao logDao = new LogDao();
        DatabaseAppender databaseAppender = new DatabaseAppender(new ArrayBlockingQueue<>(5), Executors.newFixedThreadPool(2), logDao);

        LoggerContext loggerContext = LoggerContext.getInstance();

        loggerContext.addAppender(fileAppender);
        loggerContext.addAppender(databaseAppender);

        Logger logger = Logger.getInstance(loggerContext);

        runSomething(logger);

        loggerContext.stop();

    }

    public static void runSomething(Logger logger) {
        try {

            for(int i = 0; i <= 10; i++) {

                logger.debug("value is: " + i);

                if(i == 10) {

                    logger.warn("value is: " + i);

                }

            }

        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}