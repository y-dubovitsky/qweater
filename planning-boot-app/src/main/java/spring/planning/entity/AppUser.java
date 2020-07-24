package spring.planning.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "ENCRYTED_PASSWORD")
    private String password;

    @Column(name = "enabled")
    private int enabled;


}
