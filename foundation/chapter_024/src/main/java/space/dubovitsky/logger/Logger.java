package space.dubovitsky.logger;

import org.springframework.stereotype.Component;

@Component
public class Logger {

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }

    public void afterReturningParam(Object object) {
        if (object instanceof Double) {
            System.out.println("This is Double : " + object);
        } else {
            System.out.println("Nope, this isnt double");
        }
    }

    public void afterThrowException(Exception e) {
        System.out.println("Message : " + e.getMessage());
    }
}
