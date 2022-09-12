package ru.evaproj.analyst.analysis.service.cutter;

import ru.evaproj.analyst.analysis.exception.CutterTypeNotDefinedException;
import ru.evaproj.analyst.analysis.models.CutterType;

public abstract class CutterFactory {

    public static Cutter getCutter(CutterType type) {
        switch (type) {
            case SIMPLE: return new CutterSimple();
            case CURRENT_PRICE: return new CutterCurrentPrice();
            case LAST_CANDLE: return new CutterLastCandle();
            case LAST_EXTREMUM: return new CutterLastExtremum();
            case AVERAGE_EXTREMUM: return new CutterAverageExtremum();
            default: new CutterTypeNotDefinedException(type.toString());
        }

        return new CutterSimple();
    }
}
