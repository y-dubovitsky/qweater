package aop.music;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LetsPlay {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.music/config.xml");

        Musician baritone = (Musician) context.getBean("baritone");
        baritone.play();
    }
}
