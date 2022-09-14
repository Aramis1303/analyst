package ru.evaproj.analyst.analysis.service.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.dto.CandleSegmentDto;
import ru.evaproj.analyst.analysis.dto.ClusterNodeDto;
import ru.evaproj.analyst.analysis.models.ClusterType;
import ru.evaproj.analyst.analysis.service.cluster.ClusterService;
import ru.evaproj.analyst.analysis.service.cutter.CutterService;

import java.util.List;

@Service
public class ClusterServiceImpl implements ClusterService {

    @Autowired
    CutterService cutterService;

    @Autowired
    ClusterFactory clusterFactory;

    @Override
    public List<ClusterNodeDto> clustering(List<CandleSegmentDto> segmentList, ClusterType type, Integer amountOfClusters) {

        return clusterFactory.getAlgorithm(type).clustering(segmentList, amountOfClusters);
    }
}
