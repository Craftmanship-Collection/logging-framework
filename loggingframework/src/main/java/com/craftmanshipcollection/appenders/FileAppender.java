package com.craftmanshipcollection.appenders;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class FileAppender implements LoggerAppender{

    private final BlockingQueue<String> logs;
    private final ExecutorService executorService;
    private final String filePath;
    private boolean running;

    public FileAppender(BlockingQueue<String> logs, ExecutorService executorService, String filePath) {
        this.logs = logs;
        this.executorService = executorService;
        this.filePath = filePath;
        this.running = true;

        try {
            Files.createDirectories(java.nio.file.Paths.get(filePath));
        } catch (Exception e) {
            System.out.println("Failed to create log directory: " + e.getMessage());
        }

        start();
    }

    @Override
    public void appendMessage(String message) throws InterruptedException {

        logs.put(message);

    }

    @Override
    public void start() {
        executorService.submit(() -> {
        while (running || !logs.isEmpty()) {
            String message = null;
            try {
                message = logs.poll(1, TimeUnit.SECONDS); // poll avoids indefinite blocking
            } catch (Exception ex) {
                System.out.println("Error taking log: " + ex.getMessage());
            }

            if (message == null) continue;

            String fileName = "log_" + LocalDate.now() + ".txt";
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(
                    Paths.get(filePath, fileName),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                bufferedWriter.write(message + "\n");
            } catch (IOException e) {
                System.out.println("Error writing log: " + e.getMessage());
            }
        }
    });
}

    @Override
    public void stop() {

        running = false;
        executorService.shutdown(); // More graceful than shutdownNow
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }

    

}
