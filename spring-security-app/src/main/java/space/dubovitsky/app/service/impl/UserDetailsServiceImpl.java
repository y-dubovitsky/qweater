package space.dubovitsky.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import space.dubovitsky.app.dao.UserDao;
import space.dubovitsky.app.model.Role;
import space.dubovitsky.app.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService}
 */
//! TODO https://ru.wikibooks.org/wiki/Spring_Security/%D0%A2%D0%B5%D1%85%D0%BD%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B9_%D0%BE%D0%B1%D0%B7%D0%BE%D1%80_Spring_Security
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userDao.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(); //* Разрешения для пользователя

        for (Role role : byUsername.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                byUsername.getUsername(),
                byUsername.getPassword(),
                grantedAuthorities
        );
    }
}
