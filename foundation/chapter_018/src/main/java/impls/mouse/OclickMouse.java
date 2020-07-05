package impls.mouse;

import interfaces.Mouse;

public class OclickMouse implements Mouse {

    @Override
    public void click() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
