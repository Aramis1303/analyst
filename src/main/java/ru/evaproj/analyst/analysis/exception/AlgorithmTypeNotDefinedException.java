package ru.evaproj.analyst.analysis.exception;

public class AlgorithmTypeNotDefinedException extends RuntimeException{

    public AlgorithmTypeNotDefinedException(String type) {
        super("Algorithm implementation " + type + " isn't defined");
    }
}
