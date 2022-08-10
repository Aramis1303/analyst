package ru.evaproj.analyst.history.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.history.dto.CandleListDto;
import ru.evaproj.analyst.history.servise.CandleService;

/**
 * @author Eva on 09.08.2022
 * Контроллер торговой истории
 **/

@RestController
@RequestMapping(("/api/history"))
public class TradeHistoryController {

    @Autowired
    CandleService candleService;


    @GetMapping
    @ApiOperation(value = "История по маркету за период", notes = "Метод позволяет получить тоговую историю по параметрам")
    public ResponseEntity<CandleListDto> getMarketHistory(
            @ApiParam(value = "Имя торгового инструмента", example = "USD") String marketName,
            @ApiParam(value = "Период свечи", example = "5") Long timeframe,
            @ApiParam(value = "Timestamp последней свечи", example = "1483439400000") Long timestamp,
            @ApiParam(value = "Глубина истории", example = "0") Long depth
    ) {

        return ResponseEntity.ok(candleService.getCandleList(
                marketName,
                timeframe,
                (Long)timestamp / 1000,
                depth
        ));
    }


}
