package space.dubovitsky.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import space.dubovitsky.ioc.component.MessageRender;
import space.dubovitsky.ioc.config.BeanConfig;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageRender messageRender = applicationContext.getBean("messageRender", MessageRender.class);

        messageRender.render();
    }

}
