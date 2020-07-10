package space.dubovitsky.database.dao.impl.sqlite;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import space.dubovitsky.database.dao.AbstractFilmDAO;
import space.dubovitsky.database.dao.FilmDAO;
import space.dubovitsky.database.handler.FilmResultSetHandler;
import space.dubovitsky.entity.Film;

import java.util.List;

@Component
public class SpringJdbcFilmDAO extends AbstractFilmDAO implements FilmDAO, InitializingBean { //! Унаследовались от интерфейся InitializingBean чтобы инициализировать jdbcTemplate

    private JdbcTemplate jdbcTemplate; //! Используется JdbcTemplate, а не NamedParameterJdbcTemplate для именнованых запросов

    public SpringJdbcFilmDAO() {
    }

    @Override
    public void insert(Film film) {
        String sql = "insert into film(name, author) values(?, ?)";
        jdbcTemplate.update(sql, new Object[] {film.getName(), film.getAuthor()}); //?
    }

    @Override
    public void delete(Film film) {
        String sql = "delete from film where id = ?";
        jdbcTemplate.update(sql, film.getId());
    }

    @Override
    public Film getFilmById(int id) {
        String sql = "select * from film where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new FilmResultSetHandler().getFilmRowMapper());
    }

    @Override
    public List<Film> getListFilmByName(String name) {
        return null;
    }

    @Override
    public List<Film> getListFilmByAuthor(String author) {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception { //! getDataSource() - объявлен в абстрактом классе родителе
        this.jdbcTemplate = new JdbcTemplate(getDataSource());
    }

    @Override
    public void insertList(List<Film> list) { //! Так плохо делать, нужно пачку сразу вставлять
        for (Film film : list) {
            insert(film);
        }
    }
}
