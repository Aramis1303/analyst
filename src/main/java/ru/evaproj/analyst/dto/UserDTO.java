package ru.evaproj.analyst.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.evaproj.analyst.validators.PasswordMatches;
import ru.evaproj.analyst.validators.ValidEmail;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatches
public class UserDTO {

    @NonNull
    @NotEmpty
    String name;

    @NonNull
    @NotEmpty
    @ValidEmail
    String email;

    @NonNull
    @NotEmpty
    String login;

    @NonNull
    @NotEmpty
    String password;

    String passwordConfim;

}
