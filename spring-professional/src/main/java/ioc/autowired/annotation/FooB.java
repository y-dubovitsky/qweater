package ioc.autowired.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FooB implements Fooable {

    private String name;

    public FooB(@Value("FooB") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
