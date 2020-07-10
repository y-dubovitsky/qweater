import impls.computer.PcPool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Коллекции:
 * Как в одни Бины, внедрять коллекции Бинов через xml.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //* First Pool
        System.out.println("//* First Pool");
        Object object = context.getBean("pcPool");
        if (object instanceof PcPool) {
            PcPool pcPool = (PcPool) object;
            pcPool.outputComputerCollection();
        }
        //* Second pool
        System.out.println("//* Second pool");
        PcPool pcPool = (PcPool) context.getBean("pcPool2");
        pcPool.outputComputerCollection();
        pcPool.outputComputerMap();
    }
}
