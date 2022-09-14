package ru.evaproj.analyst.analysis.service.cutter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.DealType;
import ru.evaproj.analyst.analysis.models.CutterType;
import ru.evaproj.analyst.history.entity.CandleEntity;
import ru.evaproj.analyst.history.repo.CandleRepo;

import java.util.*;

@Service
public class CutterServiceImpl implements CutterService {

    @Autowired
    CandleRepo candleRepo;

    @Autowired
    CutterFactory cutterFactory;

    /*
    * Нарезать историю в заданном периоде на куски с изменением ценового графика
    * marketName - итендификатор инструмента
    * timeframe - период инструмента
    * fromTimestamp - toTimestamp: Диапазон времни для нарезки
    * lenght - Длина отрезка предшествующая целевому движению графика
    * slRange - STOP LOSS в процентах
    * tpRange - TAKE PROFITE в процентах
    * */
    @Override
    public List<CandleSegmentDto> cutHistory(String marketName, Long timeframe, Integer lenght, Long fromTimestamp, Long toTimestamp, Double slRange, Double tpRange, CutterType type) {

        List <CandleEntity> candleEntities = candleRepo.findDiapasonByMarketNameAndTimeframe(marketName, timeframe, fromTimestamp, toTimestamp);
        if (candleEntities.size() < lenght) new RuntimeException("History size to short for cutting.");

        SortedMap<Long, CandleSegmentDto> segmentList = new TreeMap<>();
        segmentList.putAll(cutterFactory.getCutter(type).cut(candleEntities, lenght, DealType.LONG, slRange, tpRange));
        segmentList.putAll(cutterFactory.getCutter(type).cut(candleEntities, lenght, DealType.SHORT, slRange, tpRange));

        return new ArrayList(segmentList.values());
    }

}
