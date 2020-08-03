package space.dubovitsky.application.dao.impl;

import org.springframework.stereotype.Component;
import space.dubovitsky.application.dao.UserDao;
import space.dubovitsky.application.entity.User;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class JdbcUserDaoImpl implements UserDao {

    private static Connection connection; //! Переделать на пул соединений

    static {
        Properties properties = new Properties();
        try(InputStream is = JdbcUserDaoImpl.class.getClassLoader().getResourceAsStream("persistence.properties")) {
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

    private boolean createDatabase() {
        try {
            String sql = "CREATE DATABASE project1";
            PreparedStatement statement;
            statement = connection.prepareStatement(sql);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean dropDatabase() {
        try {
            String sql = "DROP DATABASE USERS";
            PreparedStatement st = connection.prepareStatement(sql);
            return st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            String sql = "Select * from users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                Boolean sex = resultSet.getBoolean("sex");
                String password = resultSet.getString("password");
                User user = new User(name, age, email, password, sex);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void addUser(User user) {
        try {
            String sql = "insert into users values(?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, user.getName());
            statement.setObject(2, user.getAge());
            statement.setObject(3, user.getEmail());
            statement.setObject(4, user.getPassword());
            statement.setObject(5, user.getSex());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByEmail(String email) {
        User user = null;
        try {
            String sql = "select * from users where email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Boolean sex = resultSet.getBoolean("sex");
                String password = resultSet.getString("password");
                user = new User(name, age, email, password, sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

//    public static void main(String[] args) {
//        JdbcUserDaoImpl u = new JdbcUserDaoImpl();
//        //u.dropDatabase();
//        u.createDatabase();
//    }

}
