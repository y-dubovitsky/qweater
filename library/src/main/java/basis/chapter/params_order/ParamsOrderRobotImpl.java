package basis.chapter.params_order;

import basis.part.Hand;
import basis.part.Head;
import basis.part.Leg;
import basis.robot.Robot;

/**
 * Этот класс и его xml настройка показывает как использовать разные конструторы в xml и как сетать параметры тоже через xml
 */
public class ParamsOrderRobotImpl implements Robot {

    private Hand hand;
    private Head head;
    private Leg leg;
    private int age;
    private boolean blessed;

    public ParamsOrderRobotImpl() {
    }

    public ParamsOrderRobotImpl(Hand hand, Head head, Leg leg) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    public ParamsOrderRobotImpl(Hand hand, Head head, Leg leg, int age, boolean blessed) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
        this.age = age;
        this.blessed = blessed;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBlessed() {
        return blessed;
    }

    public void setBlessed(boolean blessed) {
        this.blessed = blessed;
    }
}
