package intro.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShowMustGoOn {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("intro/aop/aspectj/aspectj.xml");

        Performer actor = (Performer) context.getBean("actor");
        actor.doAction();
    }
}
