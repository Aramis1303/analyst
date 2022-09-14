package ru.evaproj.analyst.history.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.history.dto.CandleListDto;
import ru.evaproj.analyst.history.mapper.CandleMapper;
import ru.evaproj.analyst.history.repo.CandleRepo;


@Service
public class CandleServiceImpl implements CandleService {

    @Autowired
    private CandleRepo candleRepo;

    @Autowired
    private CandleMapper candleMapper;

    @Override
    public CandleListDto getCandleList(String marketName, Long timeframe, Long timestamp, Long depth) {

        return candleMapper.entityToDto(
                candleRepo.findCandleListByMarketNameAndTimeframeTillTimestamp(
                        marketName,
                        timeframe,
                        timestamp,
                        depth
                )
        );
    }

    @Override
    public CandleListDto getCandleListForPeriod(String marketName, Long timeframe, Long fromTimestamp, Long toTimestamp) {

        return candleMapper.entityToDto(
                candleRepo.findDiapasonByMarketNameAndTimeframe(
                        marketName,
                        timeframe,
                        fromTimestamp,
                        toTimestamp
                )
        );
    }

    @Override
    public CandleListDto getFullCandleList(String marketName, Long timeframe) {

        return candleMapper.entityToDto(
                candleRepo.findAllByMarketNameAndTimeframe(
                        marketName,
                        timeframe
                )
        );
    }


}
