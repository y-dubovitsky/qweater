package impls.keyboard;

import interfaces.Keyboard;

public class LogitechKeyboard implements Keyboard {

    public LogitechKeyboard() {
    }

    @Override
    public void type() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
