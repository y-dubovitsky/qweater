package form.handler.controller;

import form.handler.model.College;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CollegeController {

    @RequestMapping(value = "/college-list-form.htm")
    public @ModelAttribute("collegeListCmd")
    CollegeListCmd setupForm() {
        return new CollegeListCmd();
    }

    @RequestMapping(value = "/college-list.htm", method = RequestMethod.POST)
    public @ModelAttribute("collegeListCmd")
    CollegeListCmd save(HttpServletRequest req,
                        @ModelAttribute("collegeListCmd") CollegeListCmd collegeListCmd,
                        BindingResult bindResult, ModelMap model) {
        // validation logic here...
        ...

        // collegeList should have the modified name in it
        List<College> collegeList = collegeListCmd.getCollegeList();
        ...

        return collegeListCmd;
    }
