package space.dubovitsky.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import space.dubovitsky.crudapp.model.User;
import space.dubovitsky.crudapp.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String findAll(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);

        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);

        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") long id, Model model) {
        User userById = userService.findUserById(id);
        model.addAttribute("user", userById);

        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }

}
