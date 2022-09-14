package ru.evaproj.analyst.analysis.service.cluster;

import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.dto.ClusterNodeDto;

import java.util.List;

public interface Clusterer {

    List<ClusterNodeDto> clustering(List <CandleSegmentDto> segmentList, Integer amountOfClusters);
}
