package space.dubovitsky.jwtapp.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import space.dubovitsky.jwtapp.model.Role;
import space.dubovitsky.jwtapp.model.Status;
import space.dubovitsky.jwtapp.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated(),
                mapToGrantedAuthority(user.getRoles())
        );
    }

    /**
     * В этом методе происходит преобразование ролей пользователя в Роли Спринг Секьюрити!
     * @param roles - Роли пользователя НЕ в контексте спринг секьюрити
     * @return
     */
    private static Set<GrantedAuthority> mapToGrantedAuthority(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

}
