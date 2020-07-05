package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.impls.car.LadaCar;
import space.dubovitsky.impls.car.MazdaCar;

/**
 * Этот пример показывает:
 * 1. Как использовать пространства имен - xmlns:p="http://www.springframework.org/schema/p" xmlns:c="http://www.springframework.org/schema/c"
 * 2. Как создавать бин через xml, если у класса есть несколько конструкторов
 */
public class App {
    public static void main( String[] args ) {
        //* Init context
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); //! Когда мы используем ApplicationContext, все бины сразу создаются, даже если мы их не используем
        //* Create bean
        Object object = context.getBean("mazdaCar");
        if (object instanceof MazdaCar) {
            MazdaCar mazdaCar = (MazdaCar) object;
            mazdaCar.drive();
        }
        //* Create bean
        LadaCar ladaCar = (LadaCar) context.getBean("ladaCar");
        ladaCar.drive();
        //* Create bean
        MazdaCar mazdaCarNameSpaceC = (MazdaCar) context.getBean("mazdaCarNameSpaceC");
        mazdaCarNameSpaceC.drive();
    }
}
