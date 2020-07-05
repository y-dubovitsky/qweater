package space.dubovitsky.jwtapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY) //! mappedBy - говорит сущности Роль, что смотри как реализована связь в сущности Юзер
    private Set<User> users;

}
