package ru.evaproj.analyst.history.servise;

import ru.evaproj.analyst.history.dto.CandleListDto;

public interface CandleService {

    CandleListDto getCandleList(String marketName, Long timeframe, Long timestamp, Long depth);

    CandleListDto getCandleListForPeriod(String marketName, Long timeframe, Long timestamp, Long depth);

    CandleListDto getFullCandleList(String marketName, Long timestamp);

}
