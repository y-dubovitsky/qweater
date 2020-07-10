package space.dubovitsky.spring.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private String mark;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "model")
    private Set<Car> car;

}
