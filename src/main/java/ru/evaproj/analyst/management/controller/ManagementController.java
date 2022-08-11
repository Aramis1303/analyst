package ru.evaproj.analyst.management.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.management.dto.ManagementDto;
import ru.evaproj.analyst.management.service.ManagementService;

import java.util.List;

/**
 * @author Eva on 11.08.2022
 * Контроллер торговой истории
 **/

@RestController
@RequestMapping("/api/management")
public class ManagementController {

    @Autowired
    ManagementService managementService;

    @PostMapping("/buy")
    @ApiOperation(value = "Покупка", notes = "Метод отправляет запрос на сделку LONG по указанному инструменту")
    public ResponseEntity<ManagementDto> buyQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(managementService.buyQuery(marketName));
    }

    @PostMapping("/sell")
    @ApiOperation(value = "Продажа", notes = "Метод отправляет запрос на сделку SHORT по указанному инструменту")
    public ResponseEntity<ManagementDto> sellQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(managementService.sellQuery(marketName));
    }

    @GetMapping("/get_opened")
    @ApiOperation(value = "Сделки", notes = "Метод возвращает все открытые сделки по всем инструментам")
    public ResponseEntity<List<ManagementDto>> openedQuery() {

        return ResponseEntity.ok(managementService.getOpenedDealQuery());
    }

    @GetMapping("/get_last_opened")
    @ApiOperation(value = "Покупка", notes = "Метод возвращает послнюю открытую сделку по указанному инструменту")
    public ResponseEntity<ManagementDto> openedQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(managementService.getLastOpenedDealQuery(marketName));
    }

    @PostMapping("/cencel")
    @ApiOperation(value = "Отмена", notes = "Метод отправляет запрос на отмену сделки")
    public ResponseEntity<ManagementDto> cancelQuery(@ApiParam(value = "Timestamp сделки") Long timestamp) {

        return ResponseEntity.ok(managementService.cancelQuery(timestamp));
    }

    @PostMapping("/close")
    @ApiOperation(value = "Отмена", notes = "Метод отправляет запрос на завершение сделки")
    public ResponseEntity<ManagementDto> closeQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(managementService.closeDeal(marketName));
    }

}
