package ru.evaproj.analyst.analysis.dto;

import ru.evaproj.analyst.history.dto.CandleDto;

import java.util.List;

/*
* Класс для отображения отрезка
*
*
* */
public class CandleSegmentDto {

    // Целевое изменение цены
    private Double changeOfTarget;

    // Кол-во свечей до целевого изменения цены
    private Integer lenghtToTarget;

    // История до изменения цены
    private List<CandleDto> candleHistory;

}
