package ioc.method_replace;

public class ReplacementTarget {

    public String formatMessage(String msg) {
        return "<h1>" + msg + "</h1>";
    }

    public String formatMessage(Object obj) {
        return "<h2>" + obj + "</h2>";
    }

}
