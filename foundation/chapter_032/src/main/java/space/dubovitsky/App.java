package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.database.dao.impl.sqlite.JdbcFilmDAO;
import space.dubovitsky.database.dao.impl.sqlite.SpringJdbcFilmDAO;
import space.dubovitsky.entity.Film;

/**
 *
 */
public class App {
    public static void main( String[] args )    {
        ApplicationContext context = new ClassPathXmlApplicationContext("FilmsApplicationContext.xml");
        //* SqliteSpringJdbcFilmDAO
        SpringJdbcFilmDAO springJdbcFilmDAO = (SpringJdbcFilmDAO) context.getBean("springJdbcFilmDAO");
        springJdbcFilmDAO.insert(new Film("Prison Break", "Lakin Stomarp"));
        Film filmById1 = springJdbcFilmDAO.getFilmById(2);
        System.out.println("id: " + filmById1.getId() + " name : " + filmById1.getName());
        //* SqliteJdbcFilmDAO
        JdbcFilmDAO jdbcFilmDAO = (JdbcFilmDAO) context.getBean("jdbcFilmDAO");
        jdbcFilmDAO.insert(new Film("Mortal Combat", "Takeshi Kitana"));
        jdbcFilmDAO.delete(new Film(1, "Delete", "Delete"));
        Film filmById = jdbcFilmDAO.getFilmById(5);
        System.out.println("filmById.getName() : " + filmById.getName());
    }
}
