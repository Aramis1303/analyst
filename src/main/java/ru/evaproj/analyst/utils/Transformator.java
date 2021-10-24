package ru.evaproj.analyst.utils;

import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.entities.UserEntity;

public class Transformator {

    public static UserDTO userEntityToDto(UserEntity user) {

        if (user == null) throw new RuntimeException("Can't to transform null to UserDTO");

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getLogin(),
                user.getPassword(),
                null
        );
    }

    public static UserEntity userDtoToEntity(UserDTO user) {

        if (user == null) throw new RuntimeException("Can't to transform null to UserDTO");

        UserEntity entry = new UserEntity();

        entry.setName(user.getName());
        entry.setLogin(user.getLogin());
        entry.setPassword(user.getPassword());
        entry.setEmail(user.getEmail());

        return entry;
    }



}
