package ru.evaproj.analyst.analysis.service.cluster;

import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.dto.ClusterNodeDto;
import ru.evaproj.analyst.history.exception.NotImplementedYetException;

import java.util.List;

@Service
public class ClustererAgglomerative implements Clusterer{

    @Override
    public List<ClusterNodeDto> clustering(List<CandleSegmentDto> segmentList, Integer amountOfClusters) {
        // TODO: Реализовать
        if (true)
            throw new NotImplementedYetException();
        return null;
    }
}
