package applications.database.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TODO Make from this class TESTS!
/**
 * Main class of application
 */
public class AppStart {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applications/database/jdbc/spitter.xml");

        // spitter object
        Spitter spitter = new Spitter();
        spitter.setFullName("Johny Bravo");
        spitter.setPassword("qqegwgwqg");
        spitter.setUserName("sexy@girl");

        Queries queries = (Queries) context.getBean("queries");
        queries.addSpitter(spitter);
        queries.getSpitterById(1);

        SpitterDao template = (SpitterDao) context.getBean("jdbcSpitterDAO");
        template.addSpitter(spitter);
        Spitter sp = template.getSpitterById(1);
        System.out.println(sp.getUserName());

        SpitterDao daoExtends = (SpitterDao) context.getBean("jdbcSpitterDaoExtends");
        Spitter s = daoExtends.getSpitterById(5);
        System.out.println("jdbcSpitterDaoExtends " + s.getUserName());
    }
}
