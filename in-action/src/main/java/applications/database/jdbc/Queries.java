package applications.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * In this class executes various sql queries;
 * And in this class not uses Spring pattern!
 */
public class Queries implements SpitterDao {

    @Autowired
    private DataSource dataSource;

    public Queries() {
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    /**
     * Queries for statements
     */
    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname) values (?, ?, ?)";

    private static final String SQL_GET_BY_ID =
            "select * from spitter where id = ?";

    /**
     * Add into table
     * @param spitter
     */
    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection(); // Получить соединение
            stmt = conn.prepareStatement(SQL_INSERT_SPITTER); // Создать запрос
            stmt.setString(1, spitter.getUserName()); // Связать параметры
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.execute(); // Выполнить запрос
        } catch (SQLException e) { // Обработать исключение (как-нибудь)
        e.printStackTrace();
        } finally {
            // TODO Повторяется шаблонный код!!!
            try {
                if (stmt != null) { // Освободить ресурсы
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            e.printStackTrace();
            }
        }
    }

    @Override
    public Spitter getSpitterById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Spitter spitter = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_GET_BY_ID);
            statement.setString(1, String.valueOf(id));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                spitter = new Spitter();
                spitter.setId(resultSet.getInt("id"));
                spitter.setUserName(resultSet.getString("userName"));
                // et.c
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return spitter;
    }
}
