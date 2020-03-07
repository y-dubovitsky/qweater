package chapter.bean_inheritance;

import chapter.params_order.ParamsOrderRobotImpl;
import part.Hand;
import part.Head;
import part.Leg;

public class ChildRobotImpl extends ParamsOrderRobotImpl {

    private boolean flag;

    public ChildRobotImpl() {
    }

    public ChildRobotImpl(Hand hand, Head head, Leg leg) {
        super(hand, head, leg);
    }

    public ChildRobotImpl(boolean flag) {
        this.flag = flag;
    }

    public ChildRobotImpl(Hand hand, Head head, Leg leg, boolean flag) {
        super(hand, head, leg);
        this.flag = flag;
    }

    @Override
    public void purpose() {
        System.out.println(this.getClass().getCanonicalName());
    }

    @Override
    public void doAction() {
        System.out.println(getClass().getCanonicalName() + " " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
