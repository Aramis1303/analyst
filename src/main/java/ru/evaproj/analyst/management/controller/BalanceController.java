package ru.evaproj.analyst.management.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evaproj.analyst.management.dto.BalanceDto;
import ru.evaproj.analyst.management.service.BalanceService;

/**
 * @author Eva on 11.08.2022
 * Контроллер торговой истории
 **/

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @GetMapping
    @ApiOperation(value = "Баланс", notes = "Метод позволяет получить текущее состояние баланса")
    public ResponseEntity<BalanceDto> getBalance() {

        return ResponseEntity.ok(balanceService.getBalance());
    }

    @PostMapping
    @ApiOperation(value = "Баланс", notes = "Метод позволяет получить текущее состояние баланса")
    public ResponseEntity<BalanceDto> queryBalance() {

        return ResponseEntity.ok(balanceService.sendBalanceQuery());
    }



}
