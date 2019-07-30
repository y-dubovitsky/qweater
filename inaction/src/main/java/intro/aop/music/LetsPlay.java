package intro.aop.music;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LetsPlay {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/music/config.xml");

        // https://stackoverflow.com/questions/13461985/classcastexception-proxy-cannot-be-cast-to-using-aop
        // use interface
        Musician baritone = (Musician) context.getBean("baritone");
        baritone.play();
    }
}
