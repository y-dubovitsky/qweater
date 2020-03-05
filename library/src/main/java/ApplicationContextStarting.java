import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import constructor.robotImpl.LiquidMetalRobotImpl;
import constructor.robotImpl.TerminatorRobotImpl;

public class ApplicationContextStarting {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//*        Constructors examples start
        Object object = context.getBean("terminatorRobotImpl"); //! Тут используется конструктор
        if (object instanceof TerminatorRobotImpl) { //* Checking
            TerminatorRobotImpl terminatorRobotImpl = (TerminatorRobotImpl) context.getBean("terminatorRobotImpl");
            terminatorRobotImpl.purpose();
            terminatorRobotImpl.doAction();
        }

        LiquidMetalRobotImpl liquidMetalRobot = (LiquidMetalRobotImpl) context.getBean("liquidMetalRobotImpl"); //! Тут используются Getters and Setters и настройки в .xml property name="hand" ref="dellHand"...
        liquidMetalRobot.doAction();
        liquidMetalRobot.purpose();

    }
}
