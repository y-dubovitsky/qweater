package space.dubovitsky.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import space.dubovitsky.application.dao.UserDao;
import space.dubovitsky.application.entity.User;
import space.dubovitsky.application.validation.UserValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/list")
    public String getUserList(
            Model model
    ) {
        model.addAttribute("users", userDao.findAllUser());

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
        userValidator.validate(user, result); //! Тут ошибка высплывает, что то там с локалью

        if (result.hasErrors()) {
            return "/user-register";
        }

        userDao.addUser(user);
        return "redirect:/user/list";
    }

}
