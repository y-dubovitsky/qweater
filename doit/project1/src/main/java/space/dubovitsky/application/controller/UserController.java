package space.dubovitsky.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import space.dubovitsky.application.entity.User;

import javax.validation.Valid;
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

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user-register";
    }

    @PostMapping("/register")
    public String registerModelAttribute(
            @ModelAttribute @Valid User user,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/user-register";
        }

        users.add(user);
        return "redirect:/user/list";
    }

}
