import impls.computer.Pc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1. Как наследуются Бины. Не стоит путать, что наследоване Бинов - это просто наследование конфигураций, а наследование классов - это наследование функционала.
 * 2. Порядок создания бинов:
 *  - Просто продебаж код.
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Object object = context.getBean("pc");
        if (object instanceof Pc) {
            Pc pc = (Pc) object;
            pc.calculate();
        }
    }

}
