package ru.evaproj.analyst.history.dto;

import lombok.Value;


@Value
public class CandleDto {

    private Long timestamp;

    private Double open;
    private Double close;
    private Double high;
    private Double low;

    private Long volume;

}
