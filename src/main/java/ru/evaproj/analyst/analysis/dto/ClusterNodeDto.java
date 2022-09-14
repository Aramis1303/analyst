package ru.evaproj.analyst.analysis.dto;

import ru.evaproj.analyst.analysis.models.ClusterType;

import java.util.List;

public class ClusterNodeDto {

    private Integer clusterId;

    private ClusterType clusterType;

    private List<CandleSegmentDto> segmentList;
}
