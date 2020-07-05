package space.dubovitsky.database.dao.impl.sqlite;

import org.springframework.stereotype.Component;

import space.dubovitsky.database.dao.AbstractFilmDAO;
import space.dubovitsky.database.dao.FilmDAO;
import space.dubovitsky.database.handler.FilmResultSetHandler;
import space.dubovitsky.entity.Film;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
//? @DependsOn(value = "abstractFilmDAO") - Почему не работает?
public class JdbcFilmDAO extends AbstractFilmDAO implements FilmDAO {

    public JdbcFilmDAO() {
    }

    @Override
    public void insert(Film film) {
        String sql = "insert into film(name, author) values(?, ?)";
        try {
            PreparedStatement preparedStatement = getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getAuthor());
            preparedStatement.execute();
        } catch (SQLException s) {
            System.out.println(s.getErrorCode());
        }
    }

    @Override
    public void delete(Film film) {
        String sql = "delete from film where id = ?";
        try {
            PreparedStatement preparedStatement = getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, film.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException s) {
            System.out.println(s.getErrorCode());
        }
    }

    @Override
    public Film getFilmById(int id) {
        String sql = "select * from film where id = ?";
        try {
            PreparedStatement preparedStatement = getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Film film = new FilmResultSetHandler().getFilmResultSet(resultSet); //! Сделано по уродски
            return film;
        } catch (SQLException s) {
            throw new RuntimeException(s + "public Film getFilmById(int id)");
        }
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
    public void insertList(List<Film> list) {

    }
}
