package logmain;

import appender.Appender;
import appender.FileAppender;
import logformatter.Formatter;
import logformatter.PlainTextFormatter;

class LoggerService {


    Formatter formatter ;
    Appender appender;
    static LoggerService loggerService;
    private LoggerService() {
        formatter = new PlainTextFormatter();
        appender = new FileAppender();
    }

    public static LoggerService getInstance() {
        if(loggerService != null){
            return loggerService;
        }
        else{
            return new LoggerService();
        }
    }

    public void log(LoggingLevel loggingLevel, String msg, Object[] args) {

        Object output = formatter.format(loggingLevel,msg,args);
        appender.push(output);

    }


    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public void setAppender(Appender appender) {
        this.appender = appender;
    }


}
