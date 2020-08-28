package space.dubovitsky.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.ioc.component.MessageRender;

/**
 * Point of entry
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-context.xml");
        MessageRender messageRender = applicationContext.getBean("messageRender", MessageRender.class);

        messageRender.render();
    }

}
