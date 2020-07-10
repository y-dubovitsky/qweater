package space.dubovitsky.impls;

import space.dubovitsky.interfaces.Hair;

public class HairRed implements Hair {
    @Override
    public void dye() {
        System.out.println("I dyed my hair Red");
    }
}
