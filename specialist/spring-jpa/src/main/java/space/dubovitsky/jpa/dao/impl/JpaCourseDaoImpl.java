package space.dubovitsky.jpa.dao.impl;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import space.dubovitsky.jpa.dao.CourseDao;
import space.dubovitsky.jpa.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Log
@Repository
@Transactional
public class JpaCourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAllCourses() {
        List<Course> courseList = entityManager.createQuery("select c from Course c", Course.class).getResultList();
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course getCourseById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.id=:id", Course.class);
        query.setParameter("id", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public void deleteCourseById(int id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }

    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
        log.info(String.format("Course with id %s was added", course.getId()));
    }

    @Override
    public void updateCourse(Course course) {
        if ( course != null && (entityManager.find(Course.class, course.getId()) != null) ) {
            entityManager.merge(course);
        }
    }

    @Override
    public List<Course> findByTitle(String title) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.title LIKE :title", Course.class);
        query.setParameter("title", "%" + title + "%");
        List<Course> resultList = query.getResultList();
        return resultList;
    }
}
