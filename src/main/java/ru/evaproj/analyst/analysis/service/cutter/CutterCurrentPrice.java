package ru.evaproj.analyst.analysis.service.cutter;

import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.DealType;
import ru.evaproj.analyst.history.entity.CandleEntity;

import java.util.List;
import java.util.SortedMap;

public class CutterCurrentPrice implements Cutter {

    @Override
    public SortedMap<Long, CandleSegmentDto> cut(List<CandleEntity> candleList, DealType dealType, Double slRange, Double tpRange) {
        // TODO: Реализовать
        return null;
    }
}
