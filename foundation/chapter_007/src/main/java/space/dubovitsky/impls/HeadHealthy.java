package space.dubovitsky.impls;

import space.dubovitsky.interfaces.Head;

public class HeadHealthy implements Head {
    @Override
    public void think() {
        System.out.println("I have a HEALTHY head");
    }
}
