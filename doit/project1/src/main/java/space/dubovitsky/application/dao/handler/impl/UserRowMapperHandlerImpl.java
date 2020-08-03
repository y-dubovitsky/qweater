package space.dubovitsky.application.dao.handler.impl;

import org.springframework.stereotype.Component;
import space.dubovitsky.application.dao.handler.RowMapperHandler;
import space.dubovitsky.application.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

// Можно так, можно через ляьбду, или внутренний класс ну и еще разные варианты
@Component
public class UserRowMapperHandlerImpl implements RowMapperHandler<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");
        boolean sex = resultSet.getBoolean("sex");
        String password = resultSet.getString("password");
        return new User(name, age, email, password, sex);
    }
}
