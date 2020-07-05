package impls.computer;

import interfaces.Computer;
import interfaces.Keyboard;
import interfaces.Mouse;
import org.springframework.beans.factory.InitializingBean;

public class Pc implements Computer, InitializingBean {

    private Keyboard keyboard;
    private Mouse mouse;
    private String power;

    public Pc() {
        System.out.println();
        System.out.println("Constructor " + this);
        System.out.println(this.power);
        System.out.println(this.keyboard);
        System.out.println(this.mouse);
        System.out.println();
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
        System.out.println(this.keyboard);
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
        System.out.println(this.mouse);
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
        System.out.println(this.power);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println();
        System.out.println("afterPropertiesSet " + this);
        System.out.println(this.power);
        System.out.println(this.keyboard);
        System.out.println(this.mouse);
        System.out.println();
    }
}
