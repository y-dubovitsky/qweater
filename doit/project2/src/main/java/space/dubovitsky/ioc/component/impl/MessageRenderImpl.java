package space.dubovitsky.ioc.component.impl;

import space.dubovitsky.ioc.component.MessageProvider;
import space.dubovitsky.ioc.component.MessageRender;

public class MessageRenderImpl implements MessageRender {

    private final MessageProvider messageProvider;

    public MessageRenderImpl(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void render() {
        System.out.println(messageProvider.getMessage());
    }
}
