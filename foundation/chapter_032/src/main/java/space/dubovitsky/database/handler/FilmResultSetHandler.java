package space.dubovitsky.database.handler;

import org.springframework.jdbc.core.RowMapper;
import space.dubovitsky.entity.Film;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmResultSetHandler implements ResultSetHandler<Film> {

    @Override
    public final Film getFilmResultSet(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            return new Film(id, name, author);
        } catch (SQLException e) {
            throw new RuntimeException(e + "public Film getFilm(ResultSet resultSet)"); //! Так делать не стоит
        }
    }

    @Override
    public final RowMapper<Film> getFilmRowMapper() {
        return new RowMapper<Film>() {
            @Override
            public Film mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                Film film = new Film(id, name, author);
                return film;
            }
        };
    }
}
