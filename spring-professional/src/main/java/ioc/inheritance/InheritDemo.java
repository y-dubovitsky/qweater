package ioc.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.swing.plaf.basic.BasicIconFactory;

/**
 * В этом классе показано как используется наследование свойств одного бина другим!
 */
public class InheritDemo {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext();
        ((GenericXmlApplicationContext) context).load("classpath:ioc/inheritance/inherite-xml.xml");
        ((GenericXmlApplicationContext) context).refresh();

        Kid kid1 = (Kid) context.getBean("parent", Kid.class);
        Kid kid2 = (Kid) context.getBean("child", Kid.class);
        System.out.println(kid1);
        System.out.println(kid2);

        // Изменим значение в родителе
        kid1.setAge(555);
        System.out.println(kid1);
        System.out.println(kid2);

        // Получаем другой объект
        Boy boy1 = (Boy) context.getBean("boy", Boy.class);
        System.out.println(boy1);

        // Еще один объект который никак не связан с Boy, Kid
        NotRelation not = context.getBean(NotRelation.class);
        System.out.println(not);
    }
}
