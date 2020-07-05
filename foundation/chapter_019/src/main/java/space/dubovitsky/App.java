package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.interfaces.Human;

/**
 * Автоматическое связывание (Продебаж Код, чтобы посмотреть как создаются Бины и вызываются конструкторы)
 *
 * Вызываеься:
 * public HumanPainter() { - но дальше конструктор не идет,
 *
 * отрабатывает :
 *     public AbstractHuman() {
 *         System.out.println("Constructor : public AbstractHuman()");
 *     }
 *
 * И завершает работу :
 * System.out.println("Constructor : public HumanPainter()");
 *     }
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Human human = (Human) context.getBean("humanPainter");
        human.beHuman();
    }
}