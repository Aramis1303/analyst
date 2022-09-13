package ru.evaproj.analyst.history.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.history.servise.HistoryInformationService;

import java.util.List;

/**
 * @author Eva on 10.08.2022
 * Контроллер торговой истории
 **/

@RestController
@RequestMapping("/api/history/info")
public class HistoryInfoController {

    @Autowired
    HistoryInformationService marketService;


    @GetMapping("market_list")
    @ApiOperation(value = "Список маркетов", notes = "Метод позволяет получить список маркетов")
    public ResponseEntity<List<String>> getMarketList() {

        return ResponseEntity.ok(marketService.getAllMarketNames());
    }

    @GetMapping("timeframes_list")
    @ApiOperation(value = "Список timeframe'ов", notes = "Метод позволяет получить всех timeframe'ов")
    public ResponseEntity<List<Long>> getTimeframeList() {

        return ResponseEntity.ok(marketService.getAllTimeframes());
    }

    @GetMapping("timeframes_list_by_market")
    @ApiOperation(value = "Список timeframe'ов", notes = "Метод позволяет получить список timeframe'ов для конкретного маркета")
    public ResponseEntity<List<Long>> getTimeframeListByMarketName(@ApiParam(value = "Наименование маркета", example = "USD") String marketName) {

        return ResponseEntity.ok(marketService.getTimeframesByMarketName(marketName));
    }

}
