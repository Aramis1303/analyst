package ru.evaproj.analyst.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String e) {
        super (e);
    }

}
