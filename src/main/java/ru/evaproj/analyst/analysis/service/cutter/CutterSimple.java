package ru.evaproj.analyst.analysis.service.cutter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.models.DealType;
import ru.evaproj.analyst.history.entity.CandleEntity;
import ru.evaproj.analyst.history.mapper.CandleMapper;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class CutterSimple  implements Cutter {

    @Autowired
    CandleMapper candleMapper;

    @Override
    public synchronized SortedMap<Long, CandleSegmentDto> cut(List<CandleEntity> candleList, Integer historyLenght, DealType dealType, Double slRange, Double tpRange) {
        //TODO: Дописать игнорирование 1 свечи в качестве конца отрезка, если та входит в диапазон коммиссии * 2 за сделку
        int startPoint = 0;

        SortedMap<Long, CandleSegmentDto> cutting = new TreeMap<>();

        for (int i = historyLenght; i < candleList.size(); i++) {
            if (dealType.equals(DealType.LONG)) {
                // Точка начала отрезка
                if (startPoint == 0) startPoint = i;
                // Медвежья свеча, конец отрезка
                if (candleList.get(i).getOpen() > candleList.get(i).getClose()) {
                    // Если первая же свеча медвежья, то обнуляем данные и идём искать дальше
                    if (startPoint == i) {
                        startPoint = 0;
                        continue;
                    }
                    else {
                        // Если у поледовательности есть PROFIT в рамках TAKEPROFITE, то сохраняем последовательность
                        if (candleList.get(i).getOpen() / candleList.get(startPoint).getOpen() -1 > (tpRange / 100)) {
                            cutting.put(
                                    candleList.get(i).getTimestamp(),
                                    new CandleSegmentDto(
                                            (candleList.get(i).getOpen() / candleList.get(startPoint).getOpen() -1) * 100,
                                            i - startPoint,
                                            candleMapper.entityToDto(candleList.subList((startPoint - historyLenght),  startPoint))
                                    )
                            );
                        }
                        // Обнуляем точку отсчёта
                        startPoint = 0;
                    }
                }
            }
            if (dealType.equals(DealType.SHORT)) {
                // Точка начала отрезка
                if (startPoint == 0) startPoint = i;
                // Бычья свеча, конец отрезка
                if (candleList.get(i).getOpen() < candleList.get(i).getClose()) {
                    // Если первая же свеча бычья, то обнуляем данные и идём искать дальше
                    if (startPoint == i) {
                        startPoint = 0;
                        continue;
                    }
                    else {
                        // Если у поледовательности есть PROFIT в рамках TAKEPROFITE, то сохраняем последовательность
                        if (candleList.get(i).getOpen() / candleList.get(startPoint).getOpen() -1 < (-1)*(tpRange / 100)) {
                            cutting.put(
                                    candleList.get(i).getTimestamp(),
                                    new CandleSegmentDto(
                                            (candleList.get(i).getOpen() / candleList.get(startPoint).getOpen() -1) * 100,
                                            i - startPoint,
                                            candleMapper.entityToDto(candleList.subList((startPoint - historyLenght),  startPoint))
                                    )
                            );
                        }
                        // Обнуляем точку отсчёта
                        startPoint = 0;
                    }
                }
            }

        }

        return cutting;
    }
}
