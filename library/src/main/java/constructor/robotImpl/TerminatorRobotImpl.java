package constructor.robotImpl;

import part.Hand;
import part.Head;
import part.Leg;
import robot.Robot;

public class TerminatorRobotImpl implements Robot {

    private Hand hand;
    private Head head;
    private Leg leg;

    public TerminatorRobotImpl() {} //! Обязательно нужно создавать, именно дефолтный

    public TerminatorRobotImpl(Head head, Hand hand, Leg leg) {
        this.leg = leg;
        this.hand = hand;
        this.head = head;
    }

    @Override
    public void purpose() {
        System.out.println("I will be back!");
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
