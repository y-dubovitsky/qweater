package space.dubovitsky.ioc.component.impl;

import org.springframework.stereotype.Component;
import space.dubovitsky.ioc.component.MessageProvider;
import space.dubovitsky.ioc.component.MessageRender;

@Component("messageRender")
public class MessageRenderImpl implements MessageRender {

    private final MessageProvider messageProvider;

    public MessageRenderImpl(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void render() {
        System.out.println(messageProvider.getMessage());
    }
}
