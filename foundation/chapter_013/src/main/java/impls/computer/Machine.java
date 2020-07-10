package impls.computer;

import interfaces.Computer;
import interfaces.Keyboard;
import interfaces.Mouse;

public abstract class Machine implements Computer {

    private Keyboard keyboard;
    private Mouse mouse;

    public Machine() {
        System.out.println(this + "public Machine()");
    }

    public Machine(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
