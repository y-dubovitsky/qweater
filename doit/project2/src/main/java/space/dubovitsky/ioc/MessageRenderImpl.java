package space.dubovitsky.ioc;

public class MessageRenderImpl implements MessageRender {

    private final MessageProvider messageProvider;

    public MessageRenderImpl(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public void render() {
        System.out.println(messageProvider.getMessage());
    }
}
