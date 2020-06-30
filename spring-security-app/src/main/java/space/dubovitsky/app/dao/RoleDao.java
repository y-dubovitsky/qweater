package space.dubovitsky.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import space.dubovitsky.app.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
