package logmain;

import appender.Appender;
import logformatter.Formatter;

public class LoggingFactory {


    private LoggerService service ;
    public LoggingFactory() {
        service = LoggerService.getInstance();
    }

    public void error(String msg, Object... args) {
        service.log(LoggingLevel.ERROR, msg, args);
    }

    public void info(String msg, Object... args) {
        service.log(LoggingLevel.INFO, msg, args);
    }

    public void debug(String msg, Object... args) {
        service.log(LoggingLevel.DEBUG, msg, args);
    }

    public void setFormatter(Formatter formatter) {
        service.setFormatter(formatter);
    }

    public void setAppender(Appender appender) {
        service.setAppender(appender);
    }


}
