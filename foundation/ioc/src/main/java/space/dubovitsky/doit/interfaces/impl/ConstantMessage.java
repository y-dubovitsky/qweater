package space.dubovitsky.doit.interfaces.impl;

import space.dubovitsky.doit.interfaces.Message;

public class ConstantMessage implements Message {

    @Override
    public void printMessage() {
        System.out.println(getClass().getCanonicalName());
    }
}
