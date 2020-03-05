package intro.bind.annotation.withoutxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChampionshipsApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "intro/bind.annotation/championships.xml"
        );

        Jumper jumper = (Jumper) context.getBean("jumper");
        jumper.forwardToWinn();

        Runner runner = (Runner) context.getBean("runner");
        runner.forwardToWinn();
    }
}
