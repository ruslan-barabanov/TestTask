package util;

public class MyLogger {

    private String name;

    private MyLogger(String name) {
        this.name = name;
    }

    public static MyLogger getLogger(Class c) {
        return new MyLogger(c.getName());
    }

    public void fatal(String message) {
        System.err.println(name + ": " + message);
        System.err.flush();
    }

    public void fatal(String message, Throwable t) {
        System.err.println(name + ": " + message);
        t.printStackTrace();
        System.err.flush();
    }

    public void error(String message) {
        System.err.println(name + ": " + message);
        System.err.flush();
    }

    public void error(String message, Throwable t) {
        System.err.println(name + ": " + message);
        t.printStackTrace();
        System.err.flush();
    }

    public void info(String message) {
        System.out.println(name + ": " + message);
        System.out.flush();
    }

    public void debug(String message) {
        System.out.println(name + ": " + message);
        System.out.flush();
    }

    public void trace(String message) {
        System.out.println(name + ": " + message);
        System.out.flush();
    }

}
