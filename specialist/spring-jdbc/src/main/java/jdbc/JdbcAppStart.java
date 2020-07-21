package jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import jdbc.dao.CourseDao;
import jdbc.model.Course;

public class JdbcAppStart {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:space/dubovitsky/spring/jdbc/app-context.xml");

        CourseDao courseDao = context.getBean(CourseDao.class);
        Course courseById = courseDao.getCourseById(2);
        System.out.println(courseById);

        context.close();
    }
}
