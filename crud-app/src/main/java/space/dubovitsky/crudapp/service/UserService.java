package space.dubovitsky.crudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import space.dubovitsky.crudapp.model.User;
import space.dubovitsky.crudapp.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll(Sort.by("id"));
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }
}
