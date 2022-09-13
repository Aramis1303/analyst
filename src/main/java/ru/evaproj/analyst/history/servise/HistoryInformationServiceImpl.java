package ru.evaproj.analyst.history.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.history.repo.CandleRepo;

import java.util.List;

@Service
public class HistoryInformationServiceImpl implements HistoryInformationService {

    @Autowired
    private CandleRepo candleRepo;


    @Override
    public List<String> getAllMarketNames() {
        return candleRepo.findAllMarketNames();
    }

    @Override
    public List<Long> getAllTimeframes (){
        return candleRepo.findAllTimeframes();
    }

    @Override
    public List<Long> getTimeframesByMarketName (String marketName) {
        return candleRepo.findTimeframesByMarketName(marketName);
    }

}
