package space.dubovitsky.hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.hibernate.dao.CourseDao;

public class HibernateAppStart {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/app-context.xml");

        CourseDao courseDao = context.getBean("courseDao", CourseDao.class);
        courseDao.deleteCourseById(1);

        context.close();
    }
}
