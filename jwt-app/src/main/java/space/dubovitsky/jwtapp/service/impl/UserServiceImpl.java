package space.dubovitsky.jwtapp.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import space.dubovitsky.jwtapp.model.Role;
import space.dubovitsky.jwtapp.model.Status;
import space.dubovitsky.jwtapp.model.User;
import space.dubovitsky.jwtapp.repository.RoleRepository;
import space.dubovitsky.jwtapp.repository.UserRepository;
import space.dubovitsky.jwtapp.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(User user) {
        Role role_user = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role_user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        user.setStatus(Status.ACTIVE);

        User save = userRepository.save(user);
        return save;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
