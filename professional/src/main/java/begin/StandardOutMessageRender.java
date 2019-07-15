package begin;

/**
 * Standard oud class
 */
public class StandardOutMessageRender implements MessageRender {

    /**
     * This class depends on MessageProvider class
     */
    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("Please set the messageProvider in this class: " +
                    StandardOutMessageRender.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider ms) {
        this.messageProvider = ms;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
