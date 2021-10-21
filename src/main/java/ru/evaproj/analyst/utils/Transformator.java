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
                user.getLogin()
        );
    }

}
