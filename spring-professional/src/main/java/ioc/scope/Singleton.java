package ioc.scope;

/**
 * Simple implementation of pattern - Singleton;
 */
public class Singleton {

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {    }
}
