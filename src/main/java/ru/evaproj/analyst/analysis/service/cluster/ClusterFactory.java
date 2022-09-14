package ru.evaproj.analyst.analysis.service.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.analysis.exception.AlgorithmTypeNotDefinedException;
import ru.evaproj.analyst.analysis.models.ClusterType;

@Service
public class ClusterFactory {

    @Autowired
    ClustererEMAlgorithm clustererEMAlgorithm;

    @Autowired
    ClustererKMeans clustererKMeans;


    public Clusterer getAlgorithm(ClusterType type) {
        switch (type) {
            case K_MEANS: return clustererKMeans;
            case EM_ALGORITHM: return clustererEMAlgorithm;
            default: new AlgorithmTypeNotDefinedException(type.toString());
        }

        return clustererKMeans;
    }


}
