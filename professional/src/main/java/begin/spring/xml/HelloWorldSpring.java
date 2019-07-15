package begin.spring.xml;

import begin.MessageRender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpring {
    public static void main(String... args) throws Exception {
        ApplicationContext ap = new ClassPathXmlApplicationContext("/begin/app-context.xml");
        MessageRender mr = ap.getBean("render", MessageRender.class);
        mr.render();
    }
}
