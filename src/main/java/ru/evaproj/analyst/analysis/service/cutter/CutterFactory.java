package ru.evaproj.analyst.analysis.service.cutter;

import ru.evaproj.analyst.analysis.exception.CutterTypeNotDefinedException;
import ru.evaproj.analyst.analysis.models.StopLossType;

public abstract class CutterFactory {

    public static Cutter getCutter(StopLossType type) {
        switch (type) {
            case STATIC: return new CutterStatic();
            case CURRENT_PRICE: return new CutterCurrentPrice();
            case LAST_CANDLE: return new CutterLastCandle();
            case LAST_EXTREMUM: return new CutterLastExtremum();
            default: new CutterTypeNotDefinedException(type.toString());
        }

        return new CutterStatic();
    }
}
