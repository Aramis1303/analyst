package ru.evaproj.analyst.history.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CandleListDto {

    private String marketName;

    private Long timeframe;

    private List<CandleDto> candleList;

}
