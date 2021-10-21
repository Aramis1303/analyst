package ru.evaproj.analyst.repos;

import org.springframework.data.repository.CrudRepository;
import ru.evaproj.analyst.entities.UserEntity;

public interface UserRepo extends CrudRepository <UserEntity, Long> {

    public UserEntity findByLoginAndPassword(String login, String password);
    public boolean existsByLogin(String login);
    public boolean existsByEmail(String email);
    public UserEntity save(UserEntity entity);

}
