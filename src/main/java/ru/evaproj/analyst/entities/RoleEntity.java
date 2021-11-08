package ru.evaproj.analyst.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import ru.evaproj.analyst.dto.ERole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set <UserEntity> users;

    public RoleEntity (Long id) {
        this.id = id;
    }

    public RoleEntity (ERole name) {
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return getName().toString();
    }
}
