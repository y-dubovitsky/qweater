package space.dubovitsky.database.handler;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import space.dubovitsky.entity.Film;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {

    T getFilmResultSet(ResultSet resultSet);

    RowMapper<T> getFilmRowMapper();

}
