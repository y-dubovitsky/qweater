package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.interfaces.Calculable;

/**
 * Аспекты:
 *
 * Смотри: space.dubovitsky.aspects;
 *
 * или
 *
 * execution(public double space.dubovitsky.impls.MathService.*(..) ..... =)
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Calculable mathService = (Calculable) context.getBean("mathService"); //! Используем интерфейс в качетсве типа объекта
        //mathService.getListNumbers(5);
        //mathService.getConstant();
        System.out.println(mathService.getSum(1,2));
        //mathService.printArrayNumbers(100);
        mathService.getIntArray(5,25);
        System.out.println(mathService.getDoubleValue(45.123));
    }
}
