package space.dubovitsky.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import space.dubovitsky.app.model.User;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
