package ru.evaproj.analyst.analysis.service;

import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.StopLossType;

import java.util.List;

public interface CutterService {

    List<CandleSegmentDto> cutHistory(String marketName, Integer timeframe, Integer lenght, Long fromTimestamp, Long toTimestamp, Double slRange, Double tpRange, StopLossType type);
}
