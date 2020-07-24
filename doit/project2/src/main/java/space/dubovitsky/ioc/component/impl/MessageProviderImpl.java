package space.dubovitsky.ioc.component.impl;

import space.dubovitsky.ioc.component.MessageProvider;

public class MessageProviderImpl implements MessageProvider {

    public String getMessage() {
        return "we just got some message";
    }
}
