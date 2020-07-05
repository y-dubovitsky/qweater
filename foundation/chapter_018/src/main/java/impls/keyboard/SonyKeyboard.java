package impls.keyboard;

import interfaces.Keyboard;

public class SonyKeyboard implements Keyboard {

    public SonyKeyboard() {
    }

    @Override
    public void type() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
