package space.dubovitsky.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import space.dubovitsky.application.entity.User;
import space.dubovitsky.application.service.UserService;
import space.dubovitsky.application.validation.UserValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerModelAttribute(
            @ModelAttribute @Valid User user,
            BindingResult result
    ) {
        userValidator.validate(user, result); //! Тут ошибка высплывает, что то там с локалью

        if (result.hasErrors()) {
            return "auth/register";
        }

        userService.addUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(
            @RequestParam(name = "error", required = false) Boolean error,
            Model model
            ) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "auth/login";
    }

}
