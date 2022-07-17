package ru.evaproj.analyst.history.dto;

import ru.evaproj.analyst.history.models.Timeframe;

import java.util.List;

public class CandleListDto {

    private String marketName;

    private Timeframe timeframe;

    private List<CandleDto> candleList;

}
