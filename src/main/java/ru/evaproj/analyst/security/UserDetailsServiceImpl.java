package ru.evaproj.analyst.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.entities.UserEntity;
import ru.evaproj.analyst.exceptions.EmaiAlreadyExistException;
import ru.evaproj.analyst.exceptions.UserAlreadyExistException;
import ru.evaproj.analyst.repos.RoleRepo;
import ru.evaproj.analyst.repos.UserRepo;
import ru.evaproj.analyst.utils.Transformator;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity entity = userRepo
                                .findByLogin(login)
                                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + login));

        return UserDetailsImpl.build(entity);
    }


    public void registrationUser (UserDTO user) {

        if(!user.getPassword().equals(user.getPasswordConfim())) throw new RuntimeException("Password and confirm aren't equals");
        if(userRepo.existsByLogin(user.getLogin())) throw new UserAlreadyExistException("User with login: " + user.getLogin() + " already is exist");
        if(userRepo.existsByEmail(user.getEmail())) throw new EmaiAlreadyExistException("User with email: " + user.getEmail() + " already is exist");

        UserEntity entry = Transformator.userDtoToEntity(user);

        entry.setPassword(
                encodePassword(
                        entry.getPassword()
                )
        );
        log.info("Saving new user: " + entry);
        userRepo.save(entry);
    }

    private String encodePassword(String password) {

        return bCryptPasswordEncoder.encode(password);
    }

    private boolean checkPassword(String raw, String ecoded) {

        return bCryptPasswordEncoder.matches(raw, ecoded);
    }

}
