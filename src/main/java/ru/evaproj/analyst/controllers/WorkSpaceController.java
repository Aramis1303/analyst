package ru.evaproj.analyst.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Slf4j
@Controller
public class WorkSpaceController {

    @GetMapping("/workspace")
    public String getWorkSpace(Model model, Principal principal) {
        log.info("GET /workspace");

        model.addAttribute("user", principal.getName());
        return "workspace";
    }

    @GetMapping("/analysis/anomaly")
    public String getAnomaly() {
        log.info("principal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
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
