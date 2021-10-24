package ru.evaproj.analyst.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity
@Data
public class RoleEntity  implements GrantedAuthority {

    @Id
    private Long id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set <UserEntity> users;

    @Override
    public String getAuthority() {
        return getName();
    }
}
