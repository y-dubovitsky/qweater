package ioc.dependencies;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Dependencies
 *
 * Human -> Sex
 * Table -> Chair
 */
public class DependExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/dependencies/depend-xml.xml");
        context.refresh();

        // xml config
        Human human = context.getBean("matthey", Human.class);
        human.say();

        // annotated
        Table table = context.getBean("kitchenChair", Table.class);
        table.doAction();

        context.close();
    }
}
