package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.impls.HumanPainter;
import space.dubovitsky.interfaces.Human;

/**
 * Создание Бинов через аннотации : @Bean, @Component
 *
 * https://www.ibm.com/developerworks/ru/library/ws-springjava/index.html
 *
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HumanPainter humanPainter = (HumanPainter) context.getBean("humanPainter");
        humanPainter.beHuman();

        //! Этот Бин объявлен в другом Бине
        HumanPainter createHumanPainter = (HumanPainter) context.getBean("createHumanPainter");
        createHumanPainter.beHuman();
    }
}