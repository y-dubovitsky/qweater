package ioc.singer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShowMustGoOn {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
    }
}
