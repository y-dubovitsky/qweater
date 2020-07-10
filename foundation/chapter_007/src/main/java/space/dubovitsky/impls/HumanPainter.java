package space.dubovitsky.impls;

import space.dubovitsky.interfaces.Hair;
import space.dubovitsky.interfaces.Head;
import space.dubovitsky.interfaces.Human;
import space.dubovitsky.interfaces.Leg;

public class HumanPainter implements Human {

    private Head head;
    private Hair hair;
    private Leg leg;

    public HumanPainter() { //! У бина обязательно должен быть пустой конструктор, так как IOC сперва создает все бины через рефлексию, а затем внедряет зависимости
    }

    public HumanPainter(Head head, Hair hair, Leg leg) {
        this.head = head;
        this.hair = hair;
        this.leg = leg;
    }

    public void teach() {
        System.out.println("I teach Spring Framework");
    }

    @Override
    public void doSomething() {
        hair.dye();
        head.think();
        leg.walk();
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }
}
