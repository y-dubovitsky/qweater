package space.dubovitsky.impls;

import org.springframework.stereotype.Component;
import space.dubovitsky.interfaces.Leg;

@Component
public class LegStrong implements Leg {

    @Override
    public void walk() {
        System.out.println("I have strong legs");
    }
}
