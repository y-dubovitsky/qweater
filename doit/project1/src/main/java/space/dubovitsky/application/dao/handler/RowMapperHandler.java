package space.dubovitsky.application.dao.handler;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapperHandler<T> extends RowMapper {

    T mapRow(ResultSet resultSet, int i) throws SQLException;

}
