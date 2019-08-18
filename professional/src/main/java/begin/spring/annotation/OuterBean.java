package begin.spring.annotation;

import org.springframework.stereotype.Component;

@Component("outer")
public class OuterBean implements Bean{

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
