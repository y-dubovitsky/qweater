package di.math;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class doAction {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("di/math/math.xml");
        MathAction mathAction = (MathAction) context.getBean("mathAction");
        mathAction.sout();
    }
}
