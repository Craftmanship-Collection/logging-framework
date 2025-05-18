package logformatter;

import logmain.LoggingLevel;

public interface Formatter {


    public String format();

    Object format(LoggingLevel loggingLevel, String msg, Object[] args);

}
