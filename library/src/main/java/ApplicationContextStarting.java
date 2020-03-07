import chapter.getters_setters.GetterSetterRobotImpl;
import chapter.params_order.ParamsOrderRobotImpl;
import chapter.scope.ScopeRobotImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import chapter.constructor.LiquidMetalRobotImpl;
import chapter.constructor.TerminatorRobotImpl;

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
        liquidMetalRobot.purpose();
        liquidMetalRobot.doAction();

//*        Getters and Setter example
        GetterSetterRobotImpl getterSetterRobot = (GetterSetterRobotImpl) context.getBean("getterSetterRobotImpl");
        getterSetterRobot.purpose();
        getterSetterRobot.doAction();

//*        Params in constructors and set params by setters
        ParamsOrderRobotImpl paramsOrderRobot = (ParamsOrderRobotImpl) context.getBean("paramsOrderRobotImpl");
        paramsOrderRobot.purpose();
        paramsOrderRobot.doAction();

//*        Scope and live cycle method
        ScopeRobotImpl singletonRobotImpl = (ScopeRobotImpl) context.getBean("singletonRobotImpl");
        System.out.println(singletonRobotImpl);
        singletonRobotImpl = (ScopeRobotImpl) context.getBean("singletonRobotImpl");
        System.out.println(singletonRobotImpl);

        // Так как scope singleton, то и все поля будут одинаковы, несмотря на то, что у Leg scope - prototype
        ScopeRobotImpl singletonWithPrototypeRef = (ScopeRobotImpl) context.getBean("singletonWithPrototypeRef");
        System.out.println(singletonWithPrototypeRef.getLeg());
        singletonWithPrototypeRef = (ScopeRobotImpl) context.getBean("singletonWithPrototypeRef");
        System.out.println(singletonWithPrototypeRef.getLeg());

        //! prototype scope : Каждый новый бин -> вызов init()
        ScopeRobotImpl prototypeRobotImpl = (ScopeRobotImpl) context.getBean("prototypeRobotImpl");
        System.out.println(prototypeRobotImpl);
        prototypeRobotImpl = (ScopeRobotImpl) context.getBean("prototypeRobotImpl");
        System.out.println(prototypeRobotImpl);
    }
}
