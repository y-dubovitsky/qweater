package space.dubovitsky.application.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import space.dubovitsky.application.entity.User;
import space.dubovitsky.application.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) { //! TODO Error! org.springframework.web.servlet.tags.form.ErrorsTag.doStartTag No message found under code 'This email already exists!.user.email' for locale 'ru_RU'.
//        return aClass.getClass().equals(new User());
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (userService.findUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "This email already exists!"); //? Прочитать про аргументы метода
        }
    }
}
