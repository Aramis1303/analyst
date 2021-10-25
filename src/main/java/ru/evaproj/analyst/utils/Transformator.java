package ru.evaproj.analyst.utils;

import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.entities.UserEntity;

public class Transformator {

    public static UserDTO userEntityToDto(UserEntity entity) {

        if (entity == null) throw new RuntimeException("Can't to transform null to UserDTO");

        UserDTO dto = new UserDTO();

        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setLogin(entity.getLogin());

        return dto;
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
