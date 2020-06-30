package space.dubovitsky.app.service;

import space.dubovitsky.app.model.User;

/**
 * Service class for {@link space.dubovitsky.app.model.User}
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
