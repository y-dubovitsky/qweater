package robot;

import part.Hand;
import part.Head;
import part.Leg;
import robot.Robot;

public abstract class ParentRobotImpl implements Robot {

    private Hand hand;
    private Head head;
    private Leg leg;

    public ParentRobotImpl() {
    }

    public ParentRobotImpl(Hand hand, Head head, Leg leg) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    @Override
    public void purpose() {
        System.out.println(getClass().getCanonicalName());
    }

    @Override
    public void doAction() {
        System.out.println(getClass().getCanonicalName());
    }

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
