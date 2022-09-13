package ru.evaproj.analyst.management.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.analysis.models.CutterType;
import ru.evaproj.analyst.analysis.models.DealType;
import ru.evaproj.analyst.management.models.OrderType;
import ru.evaproj.analyst.management.models.ProcessStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eva on 13.09.2022
 * Контроллер информации
 **/
@RestController
@RequestMapping("/api/management/info")
public class ManagementInformationController {

    @GetMapping("/order_type")
    @ApiOperation(value = "Типы сделок", notes = "Метод позволяет получить типы отправляемых сделок в терминал")
    public ResponseEntity<List<String>> getDealType() {

        return ResponseEntity.ok(
                Arrays.asList(OrderType.values())
                        .stream()
                        .map(e -> e.toString())
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/process_status")
    @ApiOperation(value = "Типы статусов проверок", notes = "Метод позволяет получить типы статусов проверок")
    public ResponseEntity<List<String>> getCutterType() {
        return ResponseEntity.ok(
                Arrays.asList(ProcessStatus.values())
                        .stream()
                        .map(e -> e.toString())
                        .collect(Collectors.toList())
        );
    }
}

