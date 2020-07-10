package space.dubovitsky.spring.orm.hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.spring.orm.hibernate.dao.CourseDao;

public class HibernateAppStart {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/space/dubovitsky/spring/orm/hibernate/app-context.xml");

        CourseDao courseDao = context.getBean("courseDao", CourseDao.class);
        courseDao.deleteCourseById(1);

        context.close();
    }
}
