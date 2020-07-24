package space.dubovitsky.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model
    ) {
        model.addAttribute("msg", "Hello my friend!");
        return "index";
    }

    @GetMapping("/request-param")
    public String requestParam(
            @RequestParam(value = "name", required = false, defaultValue = "Guest") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/path-variable/{variable}")
    public String pathVariable(
            @PathVariable(required = false) String variable,
            Model model
    ) {
        model.addAttribute("pathVariable", variable);
        return "index";
    }

}
