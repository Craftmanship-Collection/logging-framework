package com.craftmanshipcollection.appenders;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.craftmanshipcollection.daos.LogDao;

public class DatabaseAppender implements LoggerAppender{

    private final BlockingQueue<String> logs;
    private final ExecutorService executorService;
    private final LogDao logDao;
    private boolean running;
    

    public DatabaseAppender(
        BlockingQueue<String> logs,
        ExecutorService executorService,
        LogDao logDao
    ) {
        this.logs = logs;
        this.executorService = executorService;
        this.logDao = logDao;
        this.running = false;

        start();

    }

    @Override
    public void appendMessage(String message) {
        
        logs.offer(message);

    }

    @Override
    public void start() {
        
        executorService.submit(() -> {

            while(running || !logs.isEmpty()) {

                String message = null;

                try {

                    message = logs.take();

                }catch(Exception ex) {

                    System.out.println(ex.getMessage());

                }

                logDao.persist(message);

            }

        });

    }

    @Override
    public void stop() {

        executorService.shutdown();

        try {
            if(!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        
    }
    
}
