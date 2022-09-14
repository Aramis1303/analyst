package ru.evaproj.analyst.analysis.service.cutter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.exception.CutterTypeNotDefinedException;
import ru.evaproj.analyst.analysis.models.CutterType;

@Service
public class CutterFactory {

    @Autowired
    Cutter cutterSimple;

    @Autowired
    Cutter cutterCurrentPrice;

    @Autowired
    Cutter cutterLastCandle;

    @Autowired
    Cutter cutterLastExtremum;

    @Autowired
    Cutter cutterAverageExtremum;


    public Cutter getCutter(CutterType type) {
        switch (type) {
            case SIMPLE: return cutterSimple;
            case CURRENT_PRICE: return cutterCurrentPrice;
            case LAST_CANDLE: return cutterLastCandle;
            case LAST_EXTREMUM: return cutterLastExtremum;
            case AVERAGE_EXTREMUM: return cutterAverageExtremum;
            default: new CutterTypeNotDefinedException(type.toString());
        }

        return cutterSimple;
    }
}
