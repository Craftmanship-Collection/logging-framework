package com.craftmanshipcollection.appenders;

public interface LoggerAppender {
    
    void appendMessage(String message) throws Exception;
    void start();
    void stop();

}
