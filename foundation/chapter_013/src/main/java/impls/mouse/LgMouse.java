package impls.mouse;

import interfaces.Mouse;

public class LgMouse implements Mouse {

    public LgMouse() {
    }

    @Override
    public void click() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
