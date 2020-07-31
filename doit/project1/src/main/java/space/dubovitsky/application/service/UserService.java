package space.dubovitsky.application.service;

import space.dubovitsky.application.entity.User;

import java.util.List;

public interface UserService {


    List<User> findAllUser();

    void addUser(User user);

    User findUserByEmail(String email);

}
