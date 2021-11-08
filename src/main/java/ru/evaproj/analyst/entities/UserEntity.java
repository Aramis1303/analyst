package ru.evaproj.analyst.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(unique=true)
    private String email;

    @Column(unique=true)
    private String login;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set <RoleEntity> roles = new HashSet<>();

}
