package jdbc.dao.impl;

import jdbc.dao.CourseDao;
import jdbc.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Самое главное, что тут используется Шаблонный метод JdbcTemplate
 *
 * Шаблонный метод — это поведенческий паттерн, задающий скелет алгоритма в суперклассе и заставляющий подклассы реализовать конкретные шаги этого алгоритма.
 */
public class CourseDaoJdbcImpl implements CourseDao {

    private final static String SQL_SELECT_ALL_COURSES =
            "Select id, title, length, description from course";

    private final static String SQL_SELECT_COURSE_BY_ID =
            SQL_SELECT_ALL_COURSES + " where id = ? ";

    private JdbcTemplate jdbcTemplate; //! Это шаблонный метод - ПАТТЕРН проектирования, https://refactoring.guru/ru/design-patterns/template-method/java/example

    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public Course getCourseById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_COURSE_BY_ID, new Object[]{id},
                (resultSet, i) -> { //! Можно вынести в отдельный класс
                    Course course = new Course();
                    course.setId(resultSet.getInt("id"));
                    course.setTitle(resultSet.getString("title"));
                    course.setDescription(resultSet.getString("description"));
                    course.setLength(resultSet.getInt("length"));
                    return course;
                });
    }

    @Override
    public void deleteCourseById(int id) {

    }

    // Getters and setters

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
