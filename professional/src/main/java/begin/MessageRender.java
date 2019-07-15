package begin;

public interface MessageRender {
    /**
     * Render Message
     */
    void render();

    /**
     * Set implementations MessageProvider
     * @param ms
     */
    void setMessageProvider(MessageProvider ms);

    MessageProvider getMessageProvider();
}
