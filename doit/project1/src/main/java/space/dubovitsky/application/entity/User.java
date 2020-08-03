package space.dubovitsky.application.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Please enter the name")
    private String name;

    @Range(min=0, max=90, message = "more than 0 and less than 100")
    private int age;

    @NotBlank(message = "Please enter the email")
    @Email(message = "Please enter correct email")
    private String email;

    private String password;

    private Boolean sex;

    public User() {
    }

    public User(@NotBlank(message = "Please enter the name") String name, @Range(min = 0, max = 90, message = "more than 0 and less than 100") int age, @NotBlank(message = "Please enter the email") @Email(message = "Please enter correct email") String email, String password, Boolean sex) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.sex = sex;
    }
}
