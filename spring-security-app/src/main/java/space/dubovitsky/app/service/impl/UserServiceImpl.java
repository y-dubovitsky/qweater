package space.dubovitsky.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import space.dubovitsky.app.dao.RoleDao;
import space.dubovitsky.app.dao.UserDao;
import space.dubovitsky.app.model.Role;
import space.dubovitsky.app.model.User;
import space.dubovitsky.app.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //? Вынести в конфиг класс

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findOne(1L)); //! Hard code
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User byUsername = userDao.findByUsername(username);
        return byUsername;
    }
}
