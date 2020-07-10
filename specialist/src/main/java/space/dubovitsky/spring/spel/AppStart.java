package space.dubovitsky.spring.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.spring.spel.component.impl.SweetHome;

public class AppStart {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spel/app-context.xml");

        SweetHome sweetHome = context.getBean("sweetHome", SweetHome.class);
        sweetHome.buildHome();

    }

}
