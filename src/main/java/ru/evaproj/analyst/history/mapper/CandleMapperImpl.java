package ru.evaproj.analyst.history.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.evaproj.analyst.history.dto.CandleDto;
import ru.evaproj.analyst.history.dto.CandleListDto;
import ru.evaproj.analyst.history.entity.CandleEntity;
import ru.evaproj.analyst.history.exception.MismatchCandleMappingException;
import ru.evaproj.analyst.history.exception.NullMappingException;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CandleMapperImpl implements CandleMapper{

    @Override
    public List <CandleEntity> dtoToEntity(CandleListDto dtoList) {

        if (dtoList == null) throw new NullMappingException();

        return dtoList.getCandleList()
                .stream()
                .map(candleDto -> {
                    CandleEntity candleEntity = new CandleEntity();

                    candleEntity.setMarketName(dtoList.getMarketName());
                    candleEntity.setTimeframe(dtoList.getTimeframe());
                    candleEntity.setTimestamp(candleDto.getTimestamp());
                    candleEntity.setOpen(candleDto.getOpen());
                    candleEntity.setHigh(candleDto.getHigh());
                    candleEntity.setLow(candleDto.getLow());
                    candleEntity.setClose(candleDto.getClose());

                    return candleEntity;
                }).collect(Collectors.toList());
    }

    @Override
    public CandleListDto entityToDto(List<CandleEntity> entityList) {

        if (entityList == null) throw new NullMappingException();

        CandleListDto candleListDto = new CandleListDto();

        String marketName = entityList.get(0).getMarketName();
        Long timeframe = entityList.get(0).getTimeframe();

        candleListDto.setCandleList(entityList
                .stream()
                .map(candleEntity -> {
                    CandleDto candleDto = new CandleDto(
                            candleEntity.getTimestamp(),
                            candleEntity.getOpen(),
                            candleEntity.getClose(),
                            candleEntity.getHigh(),
                            candleEntity.getLow(),
                            candleEntity.getVolume()
                    );

                    if (!candleEntity.getMarketName().equals(marketName))
                        throw new MismatchCandleMappingException("MarketName", marketName, candleEntity.getMarketName());
                    if (!(candleEntity.getTimeframe() == timeframe))
                        throw new MismatchCandleMappingException("Timeframe", Long.toString(timeframe), Long.toString(candleEntity.getTimeframe()));

                    return candleDto;
                })
                .collect(Collectors.toList()));

        candleListDto.setMarketName(marketName);
        candleListDto.setTimeframe(timeframe);

        return candleListDto;
    }
}
