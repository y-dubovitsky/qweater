package space.dubovitsky.jwtapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.dubovitsky.jwtapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
