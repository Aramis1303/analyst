package ru.evaproj.analyst.history.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evaproj.analyst.history.dto.CandleListDto;
import ru.evaproj.analyst.history.servise.CandleService;

/**
 * @author Eva on 09.08.2022
 * Контроллер торговой истории
 **/

@RequestMapping("api/history")
public class TradeHistoryController {

    @Autowired
    CandleService candleService;


    @GetMapping
    @ApiOperation(value = "История по маркету за период", notes = "Метод позволяет получить тоговую историю по параметрам")
    @PreAuthorize("hasAnyAuthority('viewAndEditMyProfile','viewProfileParticipant', 'viewAllContracts', 'viewContracts', 'controlFootStatus')")
    public ResponseEntity<CandleListDto> getContract(
            @ApiParam(value = "Имя торгового инструмента", example = "USD") @PathVariable("contractId") String marketName,
            @ApiParam(value = "Период свечи", example = "5") @PathVariable("contractId") Long timeframe,
            @ApiParam(value = "Timestamp последней свечи", example = "1483439400000") @PathVariable("contractId") Long timestamp,
            @ApiParam(value = "Глубина истории", example = "0") @PathVariable("contractId") Long depth
    ) {

        return ResponseEntity.ok(candleService.getCandleList(
                marketName,
                timeframe,
                (Long)timestamp / 1000,
                depth
        ));
    }


}
