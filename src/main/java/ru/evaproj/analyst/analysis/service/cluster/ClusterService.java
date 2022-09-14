package ru.evaproj.analyst.analysis.service.cluster;

import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.dto.ClusterNodeDto;
import ru.evaproj.analyst.analysis.models.ClusterType;

import java.util.List;

public interface ClusterService {

    List<ClusterNodeDto> clustering(List <CandleSegmentDto> segmentList, ClusterType type, Integer amountOfClusters);

}
