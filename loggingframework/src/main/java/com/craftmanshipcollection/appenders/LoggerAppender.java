package com.craftmanshipcollection.appenders;

public interface LoggerAppender {

    void addTaskToAppender(String message);
    void removeConnection();

}

