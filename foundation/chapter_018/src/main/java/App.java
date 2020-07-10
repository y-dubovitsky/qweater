import impls.computer.PcPool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Автоматическое связывание через xml
 *
 * Самое интересное это первое:
 * Создается Бин с параметром autowire="byType" и этот Бин подхватывает все Бины подходящие по типу для коллекций и инжектит эти бины в коллекции
 *         impls.computer.Pc@793be5ca list
 *         impls.computer.Pc@2df9b86 list
 *         impls.computer.Pc@37654521 list
 *         impls.computer.Pc@15aab8c6 list
 *         impls.computer.Pc@33990a0c list
 *         pc1 : impls.computer.Pc@793be5ca
 *         pc2 : impls.computer.Pc@2df9b86
 *         pc3 : impls.computer.Pc@37654521
 *         pc4 : impls.computer.Pc@15aab8c6
 *         pc5 : impls.computer.Pc@33990a0c
 *         impls.computer.Pc@793be5ca set
 *         impls.computer.Pc@2df9b86 set
 *         impls.computer.Pc@37654521 set
 *         impls.computer.Pc@15aab8c6 set
 *         impls.computer.Pc@33990a0c set
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //* Создается Бин с параметром autowire="byType" и этот Бин подхватывает все Бины подходящие по типу для коллекций и инжектит эти бины в коллекции
        System.out.println("pcPool3");
        PcPool pcPool3 = (PcPool) context.getBean("pcPool3");
        pcPool3.showComputerList();
        pcPool3.showComputerMap();
        pcPool3.showComputerSet();
        System.out.println();

        //* Создается Бин и в него сетаются все коллекции по ИМЕНИ
        System.out.println("pcPool2");
        PcPool pcPool2 = (PcPool) context.getBean("pcPool2");
        pcPool2.showComputerList();
        pcPool2.showComputerMap();
        pcPool2.showComputerSet();
        System.out.println();

        //* Бин pcPool просто берет свою конфигурацию из другого Бина, как такогого связывания нет
        System.out.println("pcPool");
        PcPool pcPool = (PcPool) context.getBean("pcPool");
        pcPool.showComputerList();
        pcPool.showComputerMap();
        pcPool.showComputerSet();
        System.out.println();
    }
}
