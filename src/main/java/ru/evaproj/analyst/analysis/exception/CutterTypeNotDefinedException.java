package ru.evaproj.analyst.analysis.exception;

public class CutterTypeNotDefinedException extends RuntimeException{

    public CutterTypeNotDefinedException(String type) {
        super("Cutter implementation " + type + " isn't defined");
    }
}
