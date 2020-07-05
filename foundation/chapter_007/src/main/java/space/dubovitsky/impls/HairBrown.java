package space.dubovitsky.impls;

import space.dubovitsky.interfaces.Hair;

public class HairBrown implements Hair {
    @Override
    public void dye() {
        System.out.println("I dyed my hair brown");
    }
}
