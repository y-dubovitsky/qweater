package space.dubovitsky.spring.orm.jpa.dao;

import space.dubovitsky.spring.orm.jpa.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> findAllCourses();

    Course getCourseById(int id);

    void deleteCourseById(int id);

    void addCourse(Course course);

    void updateCourse(Course course);

    List<Course> findByTitle(String title);

}
