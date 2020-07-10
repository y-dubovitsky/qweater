package form.handler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/main")
    public String getMain(@RequestParam(value = "name", required = false, defaultValue = "Nobody") String name, Model model) {
        model.addAttribute("user", name);
        return "main";
    }

}
