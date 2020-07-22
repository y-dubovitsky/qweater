package space.dubovitsky.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import space.dubovitsky.application.model.Course;
import space.dubovitsky.application.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String coursesList(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);

        return "courses/list-course";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable("id") int id, Model model) {
        if (courseService.findById(id) != null) {
            courseService.deleteCourse(id);
        }

        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);

        return "courses/list-course";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("editCourse", courseService.findById(id));

        return "courses/edit-course";
    }

    // Просто пустую форму возвращает
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String emptyUserForm(Model model) {
        return "courses/edit-course";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST) // params = "forms" - не нужно, мапинг по умолчанию
    public String createNewUser(Course course, BindingResult bindingResult, Model model) {
        try{
            if (!bindingResult.hasErrors()) {
                courseService.save(course);
            }
        } finally {
            return "redirect:/courses/"; //? Лень править
        }
    }


}
