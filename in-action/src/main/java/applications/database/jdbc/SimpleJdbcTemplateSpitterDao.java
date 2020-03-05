package applications.database.jdbc;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;

/**
 * This class extends built-in support class(встроенный класс поддержки ДАО) pattern!
 */
public class SimpleJdbcTemplateSpitterDao extends SimpleJdbcTemplate {

    public SimpleJdbcTemplateSpitterDao(DataSource dataSource) {
        super(dataSource);
    }

    public SimpleJdbcTemplateSpitterDao(JdbcOperations classicJdbcTemplate) {
        super(classicJdbcTemplate);
    }
}
