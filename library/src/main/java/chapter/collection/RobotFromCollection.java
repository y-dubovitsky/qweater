package chapter.collection;

import robot.Robot;

public class RobotFromCollection implements Robot {

    private String field;

    @Override
    public void purpose() {
        System.out.println("I come from the future to Collect all robots");
    }

    @Override
    public void doAction() {
        System.out.println(getClass().getCanonicalName() + " " + field);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
