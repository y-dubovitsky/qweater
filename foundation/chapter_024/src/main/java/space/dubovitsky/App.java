package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.service.NumberService;

/**
 * AOP
 *
 * Все конфигурируется через xml
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        NumberService numberService = (NumberService) context.getBean("numberService");
        numberService.getDouble();
        numberService.divideNumbers(5,6); //! В контексте описан механизм, который будет перехватывать исключение и обрабатываеть его
    }
}
