package ioc.autowired.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // Работает если только существует ДВА родственных класса
public class FooA implements Fooable{

    private String name;

    public FooA(@Value("FooA") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
