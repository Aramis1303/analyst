package ru.evaproj.analyst.dto;

import lombok.Value;

@Value
public class UserDTO {

    Long id;
    String name;
    String email;
    String login;

}
