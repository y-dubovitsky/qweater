package impls.computer;

import interfaces.Computer;
import interfaces.Keyboard;
import interfaces.Mouse;

public class Pc implements Computer {

    private Keyboard keyboard;
    private Mouse mouse;
    private String power;

    public Pc() {
    }

    public Pc(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    @Override
    public void calculate() {

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

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
