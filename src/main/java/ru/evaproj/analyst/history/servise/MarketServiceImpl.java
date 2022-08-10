package ru.evaproj.analyst.history.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.history.repo.CandleRepo;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private CandleRepo candleRepo;


    @Override
    public List<String> getAllMarketNames() {
        return candleRepo.findAllMarketNames();
    }

}
