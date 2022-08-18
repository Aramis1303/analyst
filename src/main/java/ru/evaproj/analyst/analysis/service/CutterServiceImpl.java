package ru.evaproj.analyst.analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.history.dto.CandleDto;
import ru.evaproj.analyst.history.entity.CandleEntity;
import ru.evaproj.analyst.history.mapper.CandleMapper;
import ru.evaproj.analyst.history.repo.CandleRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CutterServiceImpl implements CutterService{

    @Autowired
    CandleRepo candleRepo;

    @Autowired
    CandleMapper candleMapper;

    /*
    * Нарезать историю в заданном периоде на куски с изменением ценового графика
    * marketName - итендификатор инструмента
    * timeframe - период инструмента
    * fromTimestamp - toTimestamp: Диапазон времни для нарезки
    * lenght - Длина отрезка предшествующая целевому движению графика
    * ignoreRange - Движение графика в % которое нас не интересует
    * targetRange - Целевое изменение цены
    * */
    @Override
    public List<CandleSegmentDto> cutHistory(String marketName, Integer timeframe, Long fromTimestamp, Long toTimestamp, Integer lenght, Double ignoreRange, Double targetRange) {
        List <CandleEntity> candleEntities = candleRepo.findRangeByMarketNameAndTimeframe(marketName, timeframe, fromTimestamp, toTimestamp);








    }


}
