package space.dubovitsky.thymeleaf.service;

import org.springframework.stereotype.Service;
import space.dubovitsky.thymeleaf.model.User;
import space.dubovitsky.thymeleaf.object.Gender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    public Map<String, User> getMapUser() {
        Map<String, User> map = new HashMap<>();
        map.put("User", new User("Matthey", 456, Gender.MALE));
        return map;
    }

    public List<User> getListUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("UserName", 123, Gender.FEMALE));
        users.add(new User("UserName", 123, Gender.FEMALE));
        users.add(new User("UserName", 123, Gender.FEMALE));
        users.add(new User("UserName", 123, Gender.FEMALE));
        return users;
    }

}
