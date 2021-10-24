package ru.evaproj.analyst.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class WorkSpaceController {

    @GetMapping("/workspace")
    public String getWorkSpace() {
        return "workspace";
    }

    @GetMapping("/analysis/anomaly")
    public String getAnomaly() {
        return "analysis_anomaly";
    }

    @GetMapping("/analysis/clustering")
    public String getClustering() {
        return "analysis_clustering";
    }

    @GetMapping("/analysis/time_series")
    public String getTimeSeries() {
        return "analysis_time_series";
    }


}
