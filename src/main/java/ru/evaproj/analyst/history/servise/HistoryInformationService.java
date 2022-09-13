package ru.evaproj.analyst.history.servise;

import java.util.List;

public interface HistoryInformationService {

    List<String> getAllMarketNames ();

    List<Long> getAllTimeframes ();

    List<Long> getTimeframesByMarketName (String marketName);

}
