package space.dubovitsky.impls;

import org.springframework.beans.factory.annotation.Autowired;
import space.dubovitsky.interfaces.Hair;
import space.dubovitsky.interfaces.Head;
import space.dubovitsky.interfaces.Human;
import space.dubovitsky.interfaces.Leg;

public abstract class AbstractHuman implements Human {

    @Autowired(required = false)
    private Hair hair;
    @Autowired(required = false)
    private Head head;
    @Autowired(required = false)
    private Leg leg;

    public AbstractHuman() {
        System.out.println("Constructor : public AbstractHuman()");
    }

    public AbstractHuman(Hair hair, Head head, Leg leg) {
        System.out.println("Constructor : public AbstractHuman(Hair hair, Head head, Leg leg)");
        this.hair = hair;
        this.head = head;
        this.leg = leg;
    }

    public Hair getHair() {
        System.out.println("public Hair getHair() " + hair);
        return hair;
    }

    public void setHair(Hair hair) {
        System.out.println("public void setHair(Hair hair)");
        this.hair = hair;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }
}
