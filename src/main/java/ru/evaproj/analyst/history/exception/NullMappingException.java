package ru.evaproj.analyst.history.exception;

public class NullMappingException extends RuntimeException {

    public NullMappingException() {
        super("Couldn't mapping null.");
    }

}
