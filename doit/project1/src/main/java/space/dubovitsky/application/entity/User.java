package space.dubovitsky.application.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class User {

    @NotBlank(message = "Please enter the name")
    private String name;

    @Range(min=0, max=90, message = "more than 0 and less than 100")
    private int age;

    @NotBlank(message = "Please enter the email")
    @Email(message = "Please enter correct email")
    private String email;

    private Boolean sex;

    public User() {
    }

    public User(String name, int age, String email, Boolean sex) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.sex = sex;
    }
}
