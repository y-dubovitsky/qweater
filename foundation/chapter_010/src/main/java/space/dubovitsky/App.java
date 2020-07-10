package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.impls.car.LadaCar;
import space.dubovitsky.impls.car.MazdaCar;
import space.dubovitsky.impls.car.MercedesCar;

/**
 * Этот пример показывает:
 * 1.
 */
public class App {
    public static void main( String[] args ) {
        //* Init context
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml"); //! Когда мы используем ApplicationContext, все бины сразу создаются, даже если мы их не используем

        //* Создается два бина где scope="prototype"
        MazdaCar mazdaCar = (MazdaCar) context.getBean("mazdaCar");
        System.out.println(mazdaCar);
        mazdaCar = (MazdaCar) context.getBean("mazdaCar");
        System.out.println(mazdaCar); //! Выведет разные адреса ячеек памяти

        //* Создается два бина где scope="prototype"
        LadaCar ladaCar = (LadaCar) context.getBean("ladaCar");
        System.out.println(ladaCar);
        ladaCar = (LadaCar) context.getBean("ladaCar");
        System.out.println(ladaCar); //! Выведет одинаковые адреса ячеек памяти

        //* По умолчанию scope="singleton"
        MercedesCar mercedesCar = (MercedesCar) context.getBean("mercedesCar");
        System.out.println(mercedesCar);
        mercedesCar = (MercedesCar) context.getBean("mercedesCar");
        System.out.println(mercedesCar); //! Выведет одинаковые адреса ячеек памяти
    }
}
