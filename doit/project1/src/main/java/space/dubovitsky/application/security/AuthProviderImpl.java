package space.dubovitsky.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import space.dubovitsky.application.entity.User;
import space.dubovitsky.application.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException { //! Объект authentication содержит в себе данные, которые нам предоставил пользователь для аутентификации
        String email = authentication.getName(); //* getName() - это почта из формы, со страницы login.ftl
        User userFromDb = userRepository.findByEmail(email);
        if (userFromDb == null) {
            throw new UsernameNotFoundException("Incorrect username.");
        }
        String password = passwordEncoder
                .encode(authentication.getCredentials()
                .toString()); //! Получаем пароль, который нам передали через форму

        if (userFromDb.getPassword() != password) {
            throw new BadCredentialsException("Wrong password!");
        }
        //* Пользователь прошел аутентификацию
        List<GrantedAuthority> authorityList = new ArrayList<>(); //Список ролей пользователей (пока пустой)

        //! Авторизуем пользователя!

        return new UsernamePasswordAuthenticationToken(userFromDb, null, authorityList); //? Null????
    }

    @Override
    public boolean supports(Class<?> aClass) { //?
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
