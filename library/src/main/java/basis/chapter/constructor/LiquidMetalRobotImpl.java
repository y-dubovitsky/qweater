package basis.chapter.constructor;

import basis.part.Hand;
import basis.part.Head;
import basis.part.Leg;
import basis.robot.Robot;

public class LiquidMetalRobotImpl implements Robot {

    private Hand hand;
    private Head head;
    private Leg leg;

    public LiquidMetalRobotImpl() {}

    public LiquidMetalRobotImpl(Head head, Hand hand, Leg leg) {
        this.leg = leg;
        this.hand = hand;
        this.head = head;
    }

    @Override
    public void purpose() {
        System.out.println("I came to kill John Connor!");
    }

    @Override
    public void doAction() {
        hand.clapHands();
        head.think();
        leg.walk();
    }

    // Getters and Setters
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
