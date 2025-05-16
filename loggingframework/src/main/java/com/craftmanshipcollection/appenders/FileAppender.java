package com.craftmanshipcollection.appenders;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.craftmanshipcollection.utils.ExecutorServiceUtils;

public class FileAppender implements LoggerAppender{

    private final String filePath;
    private final boolean append;
    private final ExecutorService executorService;

    public FileAppender(
        String filePath,
        boolean append
    ) {
        this.filePath = filePath;
        this.append = append;

        try {
            Files.createDirectories(java.nio.file.Paths.get(filePath));
        } catch (Exception e) {
            System.out.println("Failed to create log directory: " + e.getMessage());
        }

        executorService = Executors.newFixedThreadPool(1);
    }

    @Override
    public void addTaskToAppender(String message) {
        executorService.submit(() -> appendMessage(message));
    }

    @Override
    public void removeConnection() {

        ExecutorServiceUtils.shutDown(executorService);
        
    }

    private void appendMessage(String message) {

        
        String fileName = "log_" + LocalDate.now() + ".txt";
        Integer retryCount = 0;

        synchronized(FileAppender.class) {

            while(retryCount <= 3) {

                try (
                    
                    BufferedWriter bufferedWriter = Files.newBufferedWriter(
                        java.nio.file.Paths.get(filePath + "/" + fileName),
                        append ? new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND} : new StandardOpenOption[]{StandardOpenOption.CREATE}
                    )
                ) {
                    bufferedWriter.write(message + "\n");
                    break;
                } catch (Exception e) {

                    retryCount++;
                    System.out.println("Something issue occured, issue: " + e.getMessage());

                }

            }

        }

    }
    
}
