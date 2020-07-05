import impls.computer.Pc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * В этом примере показано:
 * 1. Как импортировать один xml в другой.
 * 2. Как при помощи атрибута depends-on="pc" - указать что один бин зависит от другого.
 * 3. В каком порядке создается и инициализируется Бин:
 *  - Сперва вызывается конструктор
 *  - Сетаются все поля:
         impls.keyboard.SonyKeyboard@22ff4249
         impls.mouse.LgMouse@1356d4d4
         Disel Power
 *  - ProcessBeforeInitialization
 *  - afterPropertiesSet из интерфейса InitializingBean
 *  - ProcessAfterInitialization
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Pc pc = (Pc) context.getBean("pc");
        pc.calculate();
    }

}
