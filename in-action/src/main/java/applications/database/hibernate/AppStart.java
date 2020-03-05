package applications.database.hibernate;

import applications.database.jdbc.Spitter;
import applications.database.jdbc.SpitterDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppStart {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applications/database/hibernate/hibernate.xml");

        // spitter object
        Spitter spitter = new Spitter();
        spitter.setFullName("Johny Bravo");
        spitter.setPassword("qqegwgwqg");
        spitter.setUserName("sexy@girl");

        HibernateSpitterDao spitterDao = (HibernateSpitterDao) context.getBean("hibernateSpitterDao");
        spitterDao.saveSpitter(spitter);
    }
}
