package space.dubovitsky.application.service;

import space.dubovitsky.application.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    Course findById(int id);
    void save(Course course);
    void deleteCourse(int id);

}
