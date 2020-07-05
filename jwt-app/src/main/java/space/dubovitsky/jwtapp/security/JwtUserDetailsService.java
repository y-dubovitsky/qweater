package space.dubovitsky.jwtapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import space.dubovitsky.jwtapp.model.User;
import space.dubovitsky.jwtapp.security.jwt.JwtUser;
import space.dubovitsky.jwtapp.security.jwt.JwtUserFactory;
import space.dubovitsky.jwtapp.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userService.findByUsername(username);

        if (byUsername == null) {
            throw new UsernameNotFoundException(String.format("User with username %s not found", byUsername ));
        }

        JwtUser jwtUser = JwtUserFactory.create(byUsername);

        return jwtUser;
    }
}
