package space.dubovitsky.impls;

import space.dubovitsky.interfaces.Leg;

public class LegStrong implements Leg {

    @Override
    public void walk() {
        System.out.println("I have strong legs");
    }
}
