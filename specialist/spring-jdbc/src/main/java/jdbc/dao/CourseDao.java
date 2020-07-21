package jdbc.dao;

import jdbc.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> findAllCourses();

    Course getCourseById(int id);

    void deleteCourseById(int id);

}
