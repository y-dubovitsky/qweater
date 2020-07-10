package space.dubovitsky.doit.interfaces.impl;

import space.dubovitsky.doit.annotation.AutoInsert;
import space.dubovitsky.doit.interfaces.Message;
import space.dubovitsky.doit.interfaces.Provider;

public class FirstProvider implements Provider {

    @AutoInsert
    public Message message;

    public FirstProvider() {
    }

    @Override
    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public void action() {
        message.printMessage();
    }
}
