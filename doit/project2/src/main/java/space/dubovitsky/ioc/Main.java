package space.dubovitsky.ioc;

public class Main {

    public static void main(String[] args) {
        MessageProvider messageProvider = MessageFactory.getMessageProvider();
        MessageRender messageRender = MessageFactory.getMessageRender();

        messageRender.render();
    }

}
