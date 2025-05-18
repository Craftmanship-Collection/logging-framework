simple code which gives an idea of implementation of log framework

features
get to know how to format log like JSON,XML,PLAIN TEXT
get to know how to append log to a particular location

package-overView

    logformatter -> helps to format a log
    appender -> helps to append logs


working of JSONFormatter

    logger.debug("message","1","appName"); 

    by default first parameter will be considered as message
    and remaining other parameters key will be given based on the JSONFormater object creation.