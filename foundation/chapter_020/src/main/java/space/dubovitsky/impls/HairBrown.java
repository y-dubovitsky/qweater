package space.dubovitsky.impls;

import org.springframework.stereotype.Component;
import space.dubovitsky.interfaces.Hair;

@Component
public class HairBrown implements Hair {
    @Override
    public void dye() {
        System.out.println("I dyed my hair brown");
    }
}
