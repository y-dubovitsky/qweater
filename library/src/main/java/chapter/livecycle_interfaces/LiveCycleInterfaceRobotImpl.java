package chapter.livecycle_interfaces;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import part.Hand;
import part.Head;
import part.Leg;
import robot.Robot;

public class LiveCycleInterfaceRobotImpl implements InitializingBean, DisposableBean, Robot {

    private Hand hand;
    private Head head;
    private Leg leg;

    public LiveCycleInterfaceRobotImpl() {
        System.out.println("Constructor by default " + getClass().getCanonicalName());
    }

    public LiveCycleInterfaceRobotImpl(Hand hand, Head head, Leg leg) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
        System.out.println("Constructor " + getClass().getCanonicalName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy() " + getClass().getCanonicalName());
    }

    /**
     * Из названия метода следует, что этот методы вызывыается после того как будут засетаны свойства!
     *
     * Init method from : chapter.scope.ScopeRobotImpl
     * Init method from : chapter.scope.ScopeRobotImpl
     * Constructor by default chapter.livecycle_interfaces.LiveCycleInterfaceRobotImpl
     * setHand
     * setHead
     * setLeg
     * afterPropertiesSet() chapter.livecycle_interfaces.LiveCycleInterfaceRobotImpl
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() " + getClass().getCanonicalName());
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
        System.out.println("setHand");
        this.hand = hand;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        System.out.println("setHead");
        this.head = head;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        System.out.println("setLeg");
        this.leg = leg;
    }
}
