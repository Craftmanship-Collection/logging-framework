import appender.FileAppender;
import logformatter.JSONFormatter;
import logmain.LoggingFactory;

import java.lang.module.Configuration;

public class Main {
    public static void main(String[] args) {


        LoggingFactory logger = new LoggingFactory();
        JSONFormatter formatter = new JSONFormatter("id","appName");
        logger.setFormatter(formatter);
        logger.setAppender(new FileAppender());
        logger.debug("message","1","appName");
    }


}
