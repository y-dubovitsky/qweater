package space.dubovitsky.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import space.dubovitsky.thymeleaf.model.User;
import space.dubovitsky.thymeleaf.object.Gender;
import space.dubovitsky.thymeleaf.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SyntaxThymeleafController {

    static final String BASIC_SYNTAX_PAGE = "syntax-thymeleaf";

    @Autowired
    private UserService userService;

    @GetMapping("/syntax")
    public String basicSyntax(Map<String, Object> model) {
        model.put("firstValue", "firstValue");
        model.put("secondValue", "firstValue");
        model.put("object", new User("UserName", 123, Gender.FEMALE));
        model.put("userMap", userService.getMapUser());
        model.put("userList", userService.getListUser());
        model.put("arrayParam", new String[]{"a", "b", "123"}); //* for <b>7.3 Link relative with param@{ }</b>
        model.put("value", "some text value"); //* 11. Attributes
        return BASIC_SYNTAX_PAGE;
    }
}
