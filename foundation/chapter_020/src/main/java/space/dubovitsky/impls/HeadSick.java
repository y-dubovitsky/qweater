package space.dubovitsky.impls;

import org.springframework.stereotype.Component;
import space.dubovitsky.interfaces.Head;

@Component
public class HeadSick implements Head {

    @Override
    public void think() {
        System.out.println("I have a sick head");
    }
}
