package space.dubovitsky.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(catalog = "library")
@Getter @Setter
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = "id")
@SelectBeforeUpdate
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<Book> books;

}
