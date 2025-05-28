package com.craftmanshipcollection.loggers;

import java.util.ArrayList;
import java.util.List;

import com.craftmanshipcollection.contexts.LoggerContext;
import com.craftmanshipcollection.loggerHandlers.DebugHandler;
import com.craftmanshipcollection.loggerHandlers.ErrorHandler;
import com.craftmanshipcollection.loggerHandlers.FatalHandler;
import com.craftmanshipcollection.loggerHandlers.InfoHandler;
import com.craftmanshipcollection.loggerHandlers.LoggerHandler;
import com.craftmanshipcollection.loggerHandlers.TraceHandler;
import com.craftmanshipcollection.loggerHandlers.WarnHandler;

public class Logger {
    
    private List<LoggerHandler> handlers;
    
    private Logger() {

    }

    public void setHandlers(LoggerContext context) {
        this.handlers = new ArrayList<>();
        handlers.add(new DebugHandler(context));
        handlers.add(new InfoHandler(context));
        handlers.add(new TraceHandler(context));
        handlers.add(new WarnHandler(context));
        handlers.add(new ErrorHandler(context));
        handlers.add(new FatalHandler(context));
    }

    public static Logger getInstance(LoggerContext loggerContext) {

        Logger logger = LoggerHolder.INSTANCE;

        logger.setHandlers(loggerContext);

        return logger;
        
    }


    public void debug(String message) throws Exception{

        handlers.get(0).log(message);
        
    }

    public void info(String message) throws Exception{

        handlers.get(1).log(message);

    }
    
    public void trace(String message) throws Exception{

        handlers.get(2).log(message);
    }

    public void warn(String message) throws Exception{

        handlers.get(3).log(message);

    }

    public void error(String message) throws Exception{

        handlers.get(4).log(message);

    }

    public void fatal(String message) throws Exception{

        handlers.get(5).log(message);

    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }
}
