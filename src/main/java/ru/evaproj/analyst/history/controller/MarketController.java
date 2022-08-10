package ru.evaproj.analyst.history.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.history.servise.MarketService;

import java.util.List;

/**
 * @author Eva on 10.08.2022
 * Контроллер торговой истории
 **/

@RestController
@RequestMapping("/api/market")
public class MarketController {

    @Autowired
    MarketService marketService;


    @GetMapping
    @ApiOperation(value = "Список маркетов", notes = "Метод позволяет получить список маркетов")
    public ResponseEntity<List<String>> getMarketList() {

        return ResponseEntity.ok(marketService.getAllMarketNames());
    }

}
