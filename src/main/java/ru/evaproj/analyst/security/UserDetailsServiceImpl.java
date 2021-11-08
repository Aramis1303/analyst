package ru.evaproj.analyst.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.entities.UserEntity;
import ru.evaproj.analyst.exceptions.EmaiAlreadyExistException;
import ru.evaproj.analyst.exceptions.UserAlreadyExistException;
import ru.evaproj.analyst.repos.RoleRepo;
import ru.evaproj.analyst.repos.UserRepo;
import ru.evaproj.analyst.utils.Transformator;

import java.util.Optional;

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
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.info("Try to login: " + login);

        UserEntity entity = userRepo.findByLogin(login);
        if (entity == null) throw new UsernameNotFoundException("User not found: " + login);

        log.info("Found user: " + entity);

        return UserDetailsImpl.build(entity);
    }


    public void registrationUser (UserDTO user) {
        log.info("Try to registration: " + user);
        if(!user.getPassword().equals(user.getPasswordConfim())) throw new RuntimeException("Password and confirm aren't equals");
        if(userRepo.existsByLogin(user.getLogin())) throw new UserAlreadyExistException("User with login: " + user.getLogin() + " already is exist");
        if(userRepo.existsByEmail(user.getEmail())) throw new EmaiAlreadyExistException("User with email: " + user.getEmail() + " already is exist");

        UserEntity entry = Transformator.userDtoToEntity(user);

        entry.setPassword(
                encodePassword(
                        entry.getPassword()
                )
        );

        //entry.getRoles().add(new RoleEntity(ERole.USER));

        userRepo.save(entry);
    }

    private String encodePassword(String password) {

        return bCryptPasswordEncoder.encode(password);
    }

}
