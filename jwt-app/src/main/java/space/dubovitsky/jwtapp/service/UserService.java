package space.dubovitsky.jwtapp.service;

import space.dubovitsky.jwtapp.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAllUsers();

    User findByUsername(String name);

    User findById(long id);

    void delete(long id);

}
