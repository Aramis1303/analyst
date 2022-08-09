package ru.evaproj.analyst.history.exception;

public class MismatchCandleMappingException extends RuntimeException {

    public MismatchCandleMappingException(String subject, String expected, String received){
        super("Mapping problem with field '" + subject + "': expected '" + expected + "', received '" + received + "'.");
    }
}
