package ru.evaproj.analyst.analysis.service.cutter;

import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.DealType;
import ru.evaproj.analyst.history.entity.CandleEntity;
import ru.evaproj.analyst.history.exception.NotImplementedYetException;

import java.util.List;
import java.util.SortedMap;

@Service
public class CutterLastExtremum implements Cutter {

    @Override
    public synchronized SortedMap<Long, CandleSegmentDto> cut(List<CandleEntity> candleList, Integer historyLenght, DealType dealType, Double slRange, Double tpRange) {
        // TODO: Реализовать
        if (true)
            throw new NotImplementedYetException();
        return null;
    }
}
