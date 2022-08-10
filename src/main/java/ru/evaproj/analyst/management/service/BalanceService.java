package ru.evaproj.analyst.management.service;

import ru.evaproj.analyst.management.dto.BalanceDto;

public interface BalanceService {

    BalanceDto getBalance();

    BalanceDto sendBalanceQuery();

}
