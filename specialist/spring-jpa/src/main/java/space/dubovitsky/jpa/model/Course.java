package space.dubovitsky.jpa.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
@Table(name = "course") //? Не знаю, играет ли роль регистр
public class Course implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "length")
    private int length;

    @Column(name = "description")
    private String description;

    public Course() {
    }

}
