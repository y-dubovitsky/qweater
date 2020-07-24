package space.dubovitsky.application.entity;

import lombok.Data;

@Data
public class User {

    private String name;
    private int age;
    private boolean sex;

    public User(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
