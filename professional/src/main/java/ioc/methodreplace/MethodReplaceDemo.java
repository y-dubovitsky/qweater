package ioc.methodreplace;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * This demo-class show how we can replace default method from class by the new method from other class;
 * All setting in .xml
 */
public class MethodReplaceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/methodreplace/app-context-xml.xml");
        context.refresh();

        ReplacementTarget target = (ReplacementTarget) context.getBean("methodReplacerTarget");

        ReplacementTarget standard = (ReplacementTarget) context.getBean("standartTarget");

        displayInfo(target);
        displayInfo(standard);
    }

    /**
     * This method show how long working input method, when it is invoce 100_000 times;
     * @param r
     */
    private static void displayInfo(ReplacementTarget r) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("some actions");
        String str = null;
        for (int i = 0; i < 100_000; i++) {
           str = r.formatMessage("Some action");
        }
        stopWatch.stop();
        System.out.println("This method work: " + stopWatch.getTotalTimeMillis());
        System.out.println(str);
    }
}
