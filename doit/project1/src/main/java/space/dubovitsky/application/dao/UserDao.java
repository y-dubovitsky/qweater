package space.dubovitsky.application.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserDao {

    private static Connection connection;

    static {
        Properties properties = new Properties();
        try(InputStream is = UserDao.class.getClassLoader().getResourceAsStream("persistence.properties")) {
            properties.load(is);
            Class.forName(properties.getProperty("DriverClassName"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean createDatabase() {
        try {
            String sql = "CREATE DATABASE QWERTY";
            PreparedStatement statement;
            statement = connection.prepareStatement(sql);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean dropDatabase() {
        try {
            String sql = "DROP DATABASE USERS";
            PreparedStatement st = connection.prepareStatement(sql);
            return st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UserDao u = new UserDao();
        u.dropDatabase();
    }

}
