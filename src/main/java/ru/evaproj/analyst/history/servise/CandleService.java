package ru.evaproj.analyst.history.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.history.dto.CandleDto;
import ru.evaproj.analyst.history.dto.CandleListDto;
import ru.evaproj.analyst.history.models.Timeframe;
import ru.evaproj.analyst.history.repo.CandleRepo;

import java.util.List;

@Service
public class CandleService {

    @Autowired
    private CandleRepo candleRepo;


//    public CandleListDto getCandleList(Timeframe tf, String market, int depth, long startTimestamp) {
//
//
//    }

}
