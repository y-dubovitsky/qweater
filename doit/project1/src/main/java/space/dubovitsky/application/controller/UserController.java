package space.dubovitsky.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import space.dubovitsky.application.utils.UserUtils;

@Controller
public class UserController {



    @GetMapping("/users-list")
    public String getUserList(
            Model model
    ) {
        model.addAttribute("users", UserUtils.generateUserList());

        return "user-list";
    }

}
