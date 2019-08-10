package begin.hello;

public class HelloWorld {
    public static void main(String... args) {
        MessageRender messageRender = MessageSupportFactory.getInstance().getRender();
        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
        messageRender.setMessageProvider(messageProvider);
        messageRender.render();
    }
}
