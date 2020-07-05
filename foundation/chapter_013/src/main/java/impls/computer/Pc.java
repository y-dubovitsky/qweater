package impls.computer;

import interfaces.Computer;
import interfaces.Keyboard;
import interfaces.Mouse;
import org.springframework.beans.factory.InitializingBean;

public class Pc extends Machine implements Computer, InitializingBean {

    private String power;

    public Pc() {
        System.out.println();
        System.out.println("Constructor " + this);
        System.out.println();
    }

    public Pc(String power) {
        this.power = power;
    }

    public Pc(Keyboard keyboard, Mouse mouse) {
        super(keyboard, mouse);
    }

    public Pc(Keyboard keyboard, Mouse mouse, String power) {
        super(keyboard, mouse);
        this.power = power;
    }

    @Override
    public void calculate() {
        getPower();
        getKeyboard().type();
        getMouse().click();
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
        System.out.println(getKeyboard());
        System.out.println(getMouse());
        System.out.println();
    }
}
