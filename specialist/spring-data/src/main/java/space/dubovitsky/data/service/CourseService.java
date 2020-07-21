package space.dubovitsky.data.service;

import org.springframework.stereotype.Service;
import space.dubovitsky.data.model.Course;
import space.dubovitsky.data.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCoursesByTitle(String title) {
        return courseRepository.findAllByTitle(title);
    }

    public List<Course> getAllCourses() {
        try {
            System.out.println("Invoke method getAllCourses()");
        } finally {
            return courseRepository.findAll();
        }
    }
}
