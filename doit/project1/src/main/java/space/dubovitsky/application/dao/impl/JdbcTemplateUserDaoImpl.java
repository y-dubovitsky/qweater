package space.dubovitsky.application.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import space.dubovitsky.application.dao.UserDao;
import space.dubovitsky.application.dao.handler.RowMapperHandler;
import space.dubovitsky.application.entity.User;

import java.util.List;

@Component
public class JdbcTemplateUserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapperHandler<User> rowMapperHandler;

    @Override
    public List<User> findAllUser() {
        String sql = "Select * from users";
        List<User> users = jdbcTemplate.query(sql, rowMapperHandler); //* rowMapper
        return users;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into users values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{user.getName(), user.getAge(), user.getEmail(), user.getSex()});
    }

    @Override
    public User findUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        User user = (User)jdbcTemplate.queryForObject(sql, new Object[]{email}, new BeanPropertyRowMapper(User.class));
        return user;
    }
}
