package spring.planning.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "app_role")
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long id;

    @Column(name = "role_name")
    private String roleName;

}
