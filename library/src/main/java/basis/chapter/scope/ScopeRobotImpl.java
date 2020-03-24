package basis.chapter.scope;

import basis.part.Hand;
import basis.part.Head;
import basis.part.Leg;
import basis.robot.Robot;

public class ScopeRobotImpl implements Robot {

    private Hand hand;
    private Head head;
    private Leg leg;

    public ScopeRobotImpl() {
    }

    public ScopeRobotImpl(Hand hand, Head head, Leg leg) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    @Override
    public void purpose() {
        System.out.println(this.getClass().getCanonicalName());
    }

    @Override
    public void doAction() {
        hand.clapHands();
        head.think();
        leg.walk();
    }

    /**
     * Вызываются при инициализации бина
     */
    public void init() {
        System.out.println("Init method from : " + getClass().getCanonicalName());
    }

    /**
     * Вызываются при  уничтожении бина
     */
    public void destroy() {
        System.out.println("Destroy Method : " + getClass().getCanonicalName());
    }

//    Getters and setters
    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
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
