package ru.evaproj.analyst.history.dto;

import lombok.Value;


@Value
public class CandleDto {

    private Long timestamp;

    private Long open;
    private Long close;
    private Long high;
    private Long low;
    private Long volume;

}
