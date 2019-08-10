package begin.hello;

import java.util.Properties;

/**
 * Loading classes uses properties file;
 */
public class MessageSupportFactory {

    private static MessageSupportFactory messageSupportFactory;

    private MessageProvider provider;
    private MessageRender render;
    private Properties properties;

    private MessageSupportFactory() {
        System.out.println("hello from private constructor");
        properties = new Properties();

        try {
            // https://ru.stackoverflow.com/questions/549386/%D0%93%D0%B4%D0%B5-%D0%B4%D0%BE%D0%BB%D0%B6%D0%B5%D0%BD-%D0%BD%D0%B0%D1%85%D0%BE%D0%B4%D0%B8%D1%82%D1%81%D1%8F-%D1%84%D0%B0%D0%B9%D0%BB-%D0%B4%D0%BB%D1%8F-getclassloader-getresourceasstream
            properties.load(this.getClass().getResourceAsStream("/begin/begin.properties"));
            String renderClass = properties.getProperty("render.class");
            String messageRender = properties.getProperty("provider.class");

            render = (MessageRender) Class.forName(renderClass).newInstance();
            provider = (MessageProvider) Class.forName(messageRender).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        System.out.println("hello from static block");
        messageSupportFactory = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return messageSupportFactory;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }

    public MessageRender getRender() {
        return render;
    }
}
