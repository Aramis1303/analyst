package ru.evaproj.analyst.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evaproj.analyst.dto.ERole;
import ru.evaproj.analyst.entities.RoleEntity;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<RoleEntity, Long> {
    Optional <RoleEntity> findByName (ERole name);
}
