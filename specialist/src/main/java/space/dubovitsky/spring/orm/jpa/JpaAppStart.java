package space.dubovitsky.spring.orm.jpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.spring.orm.jpa.dao.CourseDao;
import space.dubovitsky.spring.orm.jpa.model.Course;

import java.util.List;

public class JpaAppStart {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/space/dubovitsky/spring/orm/jpa/app-context.xml");

        CourseDao courseDao = context.getBean("jpaCourseDaoImpl", CourseDao.class);

        //* byId
        Course courseById = courseDao.getCourseById(2);
        System.out.println(courseById);

        //* byTitle
        List<Course> math = courseDao.findByTitle("Math");
        System.out.println(math);

        //* persist
        Course course = new Course();
        course.setTitle("Driving course");
        course.setLength(48);
        course.setDescription("No description");
        courseDao.addCourse(course);

        context.close();
    }
}
