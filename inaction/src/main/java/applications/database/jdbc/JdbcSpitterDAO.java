package applications.database.jdbc;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * In this class uses JDBC Template from Spring!
 * If we uses spring jdbc template, we do not need to handle exceptions and write a lot of code, only the logic of the work
 */
public class JdbcSpitterDAO implements SpitterDAO {

    /**
     * Attention! This is pattern code!
     */
    private SimpleJdbcTemplate jdbcTemplate;

    /**
     * Queries for statements
     */
    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname) values (?, ?, ?)";

    private static final String SQL_SELECT_SPITTER_BY_ID =
            "select * from spitter where id = ?";

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER, // Добавить запись
                spitter.getUserName(),
                spitter.getPassword(),
                spitter.getFullName());
    }

    @Override
    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_SPITTER_BY_ID,
                // TODO Обрати на это внимание!
                new ParameterizedRowMapper<Spitter>() {
                    @Override
                    public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(resultSet.getInt("id"));
                        spitter.setUserName(resultSet.getString("userName"));
                        // etc
                        return spitter;
                    }
                },
                id
        );
    }
}

