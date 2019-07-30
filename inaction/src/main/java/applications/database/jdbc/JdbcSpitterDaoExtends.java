package applications.database.jdbc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class extends SimpleJdbcDaoSupport and inherit all methods from parent class
 * include getSimpleJdbcTemplate()!!
 */
public class JdbcSpitterDaoExtends extends SimpleJdbcDaoSupport implements SpitterDao {

    private static final String SQL_INSERT_QUERY =
            "insert into spitter(username, password, fullname, email)" +
                    "values(:username, :password, :fullname, :email)";

    private static final String SQL_GET_QUERY =
            "select * from spitter where id = ?";

    // TODO Написать тест!
    @Override
    public void addSpitter(Spitter spitter) {
        Map<String, Object> param = new HashMap<>();
        param.put("username", spitter.getUserName());
        param.put("password", spitter.getPassword());
        param.put("fullname", spitter.getFullName());
        param.put("email", spitter.getEmail());
        getSimpleJdbcTemplate().update(SQL_INSERT_QUERY, param);
    }

    // TODO Написать тесты на все методы!
    @Override
    public Spitter getSpitterById(long id) {
        return getSimpleJdbcTemplate().queryForObject(
                SQL_GET_QUERY,
                // Настоящее волшебство творится в объекте ParameterizedRowMapper.
                //Для каждой строки в наборе данных, возвращаемом запросом,
                //SimpleJdbcTemplate будет вызывать метод mapRow() объекта RowMapper.
                //Внутри ParameterizedRowMapper мы добавили код, создающий объект
                //Spitter и заполняющий его свойства значениями из ResultSet.
                new ParameterizedRowMapper<Spitter>() {
                    @Override
                    public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(resultSet.getInt("id"));
                        spitter.setUserName(resultSet.getString("username"));
                        // etc
                        return spitter;
                    }
                },
                id);
    }
}
