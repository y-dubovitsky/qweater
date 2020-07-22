package space.dubovitsky.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.dubovitsky.application.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
