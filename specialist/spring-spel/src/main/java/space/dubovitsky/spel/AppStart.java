package space.dubovitsky.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.spel.component.impl.SweetHome;

public class AppStart {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/app-context.xml");

        SweetHome sweetHome = context.getBean("sweetHome", SweetHome.class);
        sweetHome.buildHome();

    }

}
