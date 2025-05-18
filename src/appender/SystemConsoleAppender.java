package appender;

public class SystemConsoleAppender implements Appender {

    @Override
    public void push(Object obj) {
        System.out.println(obj.toString());
    }
}