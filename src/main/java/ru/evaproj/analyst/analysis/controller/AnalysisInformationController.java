package ru.evaproj.analyst.analysis.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.analysis.models.CutterType;
import ru.evaproj.analyst.analysis.models.DealType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eva on 13.09.2022
 * Контроллер информации
 **/
@RestController
@RequestMapping("/api/analysis/info")
public class AnalysisInformationController {

    @GetMapping("/deal_type")
    @ApiOperation(value = "Типы сделок", notes = "Метод позволяет получить типы доступных сделок")
    public ResponseEntity<List<String>> getDealType() {

        return ResponseEntity.ok(
                Arrays.asList(DealType.values())
                        .stream()
                        .map(e -> e.toString())
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/cutter_type")
    @ApiOperation(value = "Типы сегментаций", notes = "Метод позволяет получить типы доступных сегментаций")
    public ResponseEntity<List<String>> getCutterType() {
        return ResponseEntity.ok(
                Arrays.asList(CutterType.values())
                        .stream()
                        .map(e -> e.toString())
                        .collect(Collectors.toList())
        );
    }
}
