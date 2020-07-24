package space.dubovitsky.ioc;

import java.io.InputStream;
import java.util.Properties;

public class MessageFactory {

    private static MessageProvider messageProvider;
    private static MessageRender messageRender;

    static {
        Properties properties = new Properties();
        try(InputStream is = MessageFactory.class
                .getClassLoader()
                .getResourceAsStream("properties.properties")
        ) {
            properties.load(is);
            messageProvider = (MessageProvider) Class.forName(properties.getProperty("MessageProvider")).newInstance();
            messageRender = (MessageRender) Class.forName(properties.getProperty("MessageRender"))
                    .getConstructor(MessageProvider.class)
                    .newInstance(messageProvider);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public static MessageRender getMessageRender() {
        return messageRender;
    }
}
