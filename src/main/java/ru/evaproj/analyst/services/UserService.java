package ru.evaproj.analyst.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.entities.UserEntity;
import ru.evaproj.analyst.repos.RoleRepo;
import ru.evaproj.analyst.repos.UserRepo;
import ru.evaproj.analyst.utils.Transformator;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDTO checkUser(UserDTO user) {

        UserEntity entity = userRepo.findByLoginAndPassword(user.getLogin(), encodePassword(user.getPassword()));
        if (entity != null) {
            return Transformator.userEntityToDto(entity);
        }
        else throw new RuntimeException("User not found");
    }

    public void registrationUser (UserDTO user) {

        if(!user.getPassword().equals(user.getPasswordConfim())) throw new RuntimeException("Password and confirm aren't equals");
        if(userRepo.existsByLogin(user.getLogin())) throw new RuntimeException("User with login: " + user.getLogin() + " already is exist");
        if(userRepo.existsByEmail(user.getEmail())) throw new RuntimeException("User with email: " + user.getEmail() + " already is exist");

        UserEntity entry = Transformator.userDtoToEntity(user);

        entry.setPassword(
                encodePassword(
                        entry.getPassword()
                )
        );

        userRepo.save(entry);
    }

    private String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }


}
