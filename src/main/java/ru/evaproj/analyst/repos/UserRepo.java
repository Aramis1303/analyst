package ru.evaproj.analyst.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.evaproj.analyst.entities.UserEntity;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByLogin(String login);
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
    UserEntity saveAndFlush(UserEntity entity);

}
