package ru.evaproj.analyst.analysis.dto;

import lombok.Value;
import ru.evaproj.analyst.history.dto.CandleDto;
import ru.evaproj.analyst.history.dto.CandleListDto;

import java.util.List;

/*
* Класс для отображения отрезка
*
*
* */
@Value
public class CandleSegmentDto {

    // Целевое изменение цены
    private Double changeOfTarget;

    // Кол-во свечей до целевого изменения цены
    private Integer lenghtToTarget;

    // История до изменения цены
    private CandleListDto candleHistory;

}
