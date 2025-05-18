package logformatter;

import logmain.LoggingLevel;

import java.util.*;

public class JSONFormatter implements Formatter {

    List<String> keyOrder = new ArrayList<String>();

    public JSONFormatter(String... fields) {
        this.keyOrder = Arrays.asList(fields);
    }

    @Override
    public String format() {
        return "";
    }

    @Override
    public Object format(LoggingLevel loggingLevel, String msg, Object[] args) {
        try {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("level", loggingLevel.toString());
            jsonMap.put("message", msg);
            int i =0;
            for(String key : keyOrder){
                jsonMap.put(key, args[i]);
                i+=1;
            }


            return jsonMap.toString(); // returns a JSON string
        } catch (Exception e) {
            return "{\"error\": \"Failed to format log\"}";
        }
    }


}