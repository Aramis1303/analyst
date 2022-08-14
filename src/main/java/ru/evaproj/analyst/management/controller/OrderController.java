package ru.evaproj.analyst.management.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.management.dto.OrderDto;
import ru.evaproj.analyst.management.service.OrderService;

import java.util.List;

/**
 * @author Eva on 11.08.2022
 * Контроллер торговой истории
 **/

@RestController
@RequestMapping("/api/management")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/buy")
    @ApiOperation(value = "Покупка", notes = "Метод отправляет запрос на сделку LONG по указанному инструменту")
    public ResponseEntity<OrderDto> postBuyQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(orderService.buyQuery(marketName));
    }

    @PostMapping("/sell")
    @ApiOperation(value = "Продажа", notes = "Метод отправляет запрос на сделку SHORT по указанному инструменту")
    public ResponseEntity<OrderDto> postSellQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(orderService.sellQuery(marketName));
    }

    @GetMapping("/get_all_opened")
    @ApiOperation(value = "Сделки", notes = "Метод возвращает все размещённые запросы на сделку по всем инструментам")
    public ResponseEntity<List<OrderDto>> getAllOpenedQuery() {

        return ResponseEntity.ok(orderService.getOpenedDealQuery());
    }

    @GetMapping("/get_all_performed")
    @ApiOperation(value = "Сделки", notes = "Метод возвращает все открытые сделки по всем инструментам")
    public ResponseEntity<List<OrderDto>> getAllPerformedQuery() {

        return ResponseEntity.ok(orderService.getPerformedDealQuery());
    }

    @GetMapping("/get_last_several_closed")
    @ApiOperation(value = "Сделки", notes = "Метод возвращает несколько последних завершённых сделок")
    public ResponseEntity<List<OrderDto>> getAllPerformedQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName, @ApiParam(value = "Кол-во отображаемых сделок", example = "10") Long value) {

        return ResponseEntity.ok(orderService.getLastSeveralClosed(marketName, value));
    }

    @GetMapping("/get_last_opened")
    @ApiOperation(value = "Покупка", notes = "Метод возвращает послнюю открытую сделку по указанному инструменту")
    public ResponseEntity<OrderDto> getOpenedQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(orderService.getLastOpenedDealQuery(marketName));
    }

    @PostMapping("/cencel")
    @ApiOperation(value = "Отмена", notes = "Метод отправляет запрос на отмену сделки")
    public ResponseEntity<OrderDto> postCancelQuery(@ApiParam(value = "Timestamp сделки") Long timestamp) {

        return ResponseEntity.ok(orderService.cancelQuery(timestamp));
    }

    @PostMapping("/close")
    @ApiOperation(value = "Отмена", notes = "Метод отправляет запрос на завершение сделки")
    public ResponseEntity<OrderDto> postCloseQuery(@ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName) {

        return ResponseEntity.ok(orderService.closeDeal(marketName));
    }

}
