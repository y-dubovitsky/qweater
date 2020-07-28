package space.dubovitsky.application.dao;

import space.dubovitsky.application.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAllUser();

    void addUser(User user);

    User findUserByEmail(String email);

}
