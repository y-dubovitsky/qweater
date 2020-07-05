package space.dubovitsky.thymeleaf.model;

import lombok.Getter;
import lombok.Setter;
import space.dubovitsky.thymeleaf.object.Gender;

@Getter
@Setter
public class User {

    private String name;
    private int age;
    private Gender gender;

    public User() {
    }

    public User(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getUserInfo() {
        return name + " " + age + " " + gender.name();
    }
}
