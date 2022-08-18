package ru.evaproj.analyst.analysis.service;

import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;

import java.util.List;

public interface CutterService {

    List<CandleSegmentDto> cutHistory(String marketName, Integer timeframe, Long fromTimestamp, Long toTimestamp, Integer lenght, Double ignoreRange, Double targetRange);
}
