package begin.spring.annotation;

import begin.hello.MessageRender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // "render" - this is just a name of method in Configuration class
        MessageRender messageRender = ap.getBean("render", MessageRender.class);
        messageRender.render();
    }
}
