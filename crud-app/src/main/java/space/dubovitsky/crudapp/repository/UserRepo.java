package space.dubovitsky.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.dubovitsky.crudapp.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
