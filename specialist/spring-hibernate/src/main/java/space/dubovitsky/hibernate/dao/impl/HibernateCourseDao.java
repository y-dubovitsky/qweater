package space.dubovitsky.hibernate.dao.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import space.dubovitsky.hibernate.dao.CourseDao;
import space.dubovitsky.hibernate.model.Course;

import java.util.List;

@Log
@Transactional
@Getter @Setter
@Repository(value = "courseDao")
public class HibernateCourseDao implements CourseDao {

    @Autowired //! Это как @Autowired, но из пакета javax.annotation
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAllCourses() {
        List courseList = sessionFactory.getCurrentSession()
                .createQuery("from Course c").list(); //! Регистр имеет значение(Сourse или course) HQL! И мы работаем не с таблицами уже, а с сущностями
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course getCourseById(int id) {
        log.info(String.format("Invoke method %s with args[]", "getCourseById", id));
        Course courseById = sessionFactory.getCurrentSession().byId(Course.class).load(id);
        return courseById;
    }

    @Override
    public void deleteCourseById(int id) {
        Course course = new Course();
        course.setId(id);
        sessionFactory.getCurrentSession().delete(course);
        log.info(String.format("Course %s with id %d removed successfully", course, id));
    }

    @Override
    public void addCourse(Course course) {

        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public void updateCourse(Course course) {
        sessionFactory.getCurrentSession().update(course);
    }
}
