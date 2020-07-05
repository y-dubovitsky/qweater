package space.dubovitsky.library.spring.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.logging.Level;

@Log
@Controller
public class MainController {

    @RequestMapping("/j")
    public String main(@RequestParam(name = "name", defaultValue = "user", required = false) String name, Map<String, Object> model) {
        log.log(Level.WARNING, "Main controller is executing now");
        model.put("name", name);
        return "main";
    }

    @RequestMapping("/")
    public String jsf() {
        return "redirect:/index.xhtml";
    }


}
