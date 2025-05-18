package appender;

public class FileAppender implements Appender {
    @Override
    public void push(Object obj) {
        System.out.println(obj.toString());
    }
}