package ru.evaproj.analyst.repos;

import org.springframework.data.repository.CrudRepository;
import ru.evaproj.analyst.entities.RoleEntity;

public interface RoleRepo extends CrudRepository<RoleEntity, Long> {

}
