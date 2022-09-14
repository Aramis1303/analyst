package ru.evaproj.analyst.analysis.service.cutter;

import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.CutterType;

import java.util.List;

public interface CutterService {

    List<CandleSegmentDto> cutHistory(String marketName, Long timeframe, Integer lenght, Long fromTimestamp, Long toTimestamp, Double slRange, Double tpRange, CutterType type);
}
