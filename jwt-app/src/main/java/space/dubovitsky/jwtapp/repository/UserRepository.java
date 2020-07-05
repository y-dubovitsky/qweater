package space.dubovitsky.jwtapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.dubovitsky.jwtapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
