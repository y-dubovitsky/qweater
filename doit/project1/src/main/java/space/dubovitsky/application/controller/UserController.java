package space.dubovitsky.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import space.dubovitsky.application.entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static List<User> users = new ArrayList<>();

    @GetMapping("/list")
    public String getUserList(
            Model model
    ) {
        model.addAttribute("users", users);

        return "user-list";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "sign-up";
    }

    @PostMapping("/register-request-param")
    public String registerRequestParam(
        @RequestParam(value = "name") String name,
        @RequestParam(value = "age") int age,
        @RequestParam(value = "sex") boolean sex
    ) {
        User user = new User(name, age, sex);

        users.add(user);

        return "redirect:/user/list";
    }

    @PostMapping("/register-model-attribute")
    public String registerModelAttribute(
            @ModelAttribute User user
    ) {
        users.add(user);

        return "redirect:/user/list";
    }

}
