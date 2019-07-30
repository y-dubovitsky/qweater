package applications.database.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        SpitterDAO template = (SpitterDAO) context.getBean("jdbcSpitterDAO");
        template.addSpitter(spitter);
    }
}
