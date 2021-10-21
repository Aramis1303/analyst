package ru.evaproj.analyst.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.entities.UserEntity;
import ru.evaproj.analyst.repos.UserRepo;
import ru.evaproj.analyst.utils.Transformator;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO checkUser(String login, String password) {

        UserEntity entity = userRepo.findByLoginAndPassword(login, encodePassword(password));
        if (entity != null) {
            return Transformator.userEntityToDto(entity);
        }
        else throw new RuntimeException("User not found");
    }

    public void registrationUser (String name, String login, String password, String email) {

        if(userRepo.existsByLogin(login)) throw new RuntimeException("User with login: " + login + " already is exist");
        if(userRepo.existsByEmail(email)) throw new RuntimeException("User with email: " + email + " already is exist");

        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setLogin(login);
        entity.setPassword(encodePassword(password));
        entity.setEmail(email);

        Transformator.userEntityToDto(userRepo.save(entity));
    }

    // TODO: Написать энкодер через Spring Secure
    private String encodePassword(String str) {
        return null;
    }


}
