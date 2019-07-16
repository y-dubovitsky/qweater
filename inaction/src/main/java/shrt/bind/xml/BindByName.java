package shrt.bind.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BindByName {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("shrt/bind/xml/bind.xml");

        Alcoholic alcoholic = (Man) context.getBean("mrSmith");
        alcoholic.drinkUp();

        Alcoholic mrsSmith = (MrsSmith) context.getBean("mrsSmith");
        mrsSmith.drinkUp();

        Alcoholic neighbour = (Neighbour) context.getBean("neighbour");
        neighbour.drinkUp();
    }
}
