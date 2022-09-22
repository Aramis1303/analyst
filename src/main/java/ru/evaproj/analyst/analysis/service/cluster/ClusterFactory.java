package ru.evaproj.analyst.analysis.service.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.exception.AlgorithmTypeNotDefinedException;
import ru.evaproj.analyst.analysis.models.ClusterType;

@Service
public class ClusterFactory {

    @Autowired
    ClustererGMeans clustererGMeans;

    @Autowired
    ClustererSpectral clustererSpectral;

    @Autowired
    ClustererAgglomerative clustererAgglomerative;

    @Autowired
    ClustererDBScan clustererDBScan;

    @Autowired
    ClustererMeanShift clustererMeanShift;

    public Clusterer getAlgorithm(ClusterType type) {
        switch (type) {
            case G_MAENS: return clustererGMeans;
            case SPECTRAL: return clustererSpectral;
            case DBSCAN: return clustererDBScan;
            case AGGLOMERATIVE: return clustererAgglomerative;
            case MEAN_SHIFT: return clustererMeanShift;
            default: new AlgorithmTypeNotDefinedException(type.toString());
        }

        return clustererDBScan;
    }


}
