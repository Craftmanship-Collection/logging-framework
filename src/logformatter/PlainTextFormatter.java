package logformatter;

import logmain.LoggingLevel;

public class PlainTextFormatter implements Formatter {
    @Override
    public String format() {
        return "";
    }

    @Override
    public Object format(LoggingLevel loggingLevel, String msg, Object[] args) {
        return "plain text output of " + loggingLevel.name() + ": " + msg;
    }
}