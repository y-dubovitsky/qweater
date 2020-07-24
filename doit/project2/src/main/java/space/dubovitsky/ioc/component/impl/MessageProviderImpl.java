package space.dubovitsky.ioc.component.impl;

import org.springframework.stereotype.Component;
import space.dubovitsky.ioc.component.MessageProvider;

@Component
public class MessageProviderImpl implements MessageProvider {

    public String getMessage() {
        return "we just got some message";
    }
}
