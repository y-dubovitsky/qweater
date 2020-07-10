package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.impls.HumanPainter;

/**
 * Этот пример показывает:
 * 1. как конфигурировать контейнер через xml
 * 2. как создавать бины в контексте Spring.
 * 3. как внедрять одни бины в другие через конструктор в контексте xml
 */
public class App {
    public static void main( String[] args )    {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Object object = context.getBean("humanPainter");
        if (object instanceof HumanPainter) {
            HumanPainter painter = (HumanPainter) object;
            painter.teach();
            painter.doSomething();
        }
    }
}
