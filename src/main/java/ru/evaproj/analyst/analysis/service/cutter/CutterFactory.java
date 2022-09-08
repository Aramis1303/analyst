package ru.evaproj.analyst.analysis.service.cutter;

import ru.evaproj.analyst.analysis.exception.CutterTypeNotDefinedException;
import ru.evaproj.analyst.analysis.models.StopLossType;

public abstract class CutterFactory {

    public static Cutter getCutter(StopLossType type) {
        switch (type) {
            case STATIC: return new CutterStatic();
            case DYNAMIC_CURRENT_PRICE: return new CutterDynamicCurrentPrice();
            case DYNAMIC_LAST_CANDLE: return new CutterDynamicLastCandle();
            default: new CutterTypeNotDefinedException(type.toString());
        }

        return new CutterStatic();
    }
}
