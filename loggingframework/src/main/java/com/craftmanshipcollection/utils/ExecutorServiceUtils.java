package com.craftmanshipcollection.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceUtils {

    public static void shutDown(ExecutorService executorService) {

        executorService.shutdown();
        
        try {

            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                
                executorService.shutdownNow();
            }

        } catch (InterruptedException e) {

            executorService.shutdownNow();

        }
    }
    
}
