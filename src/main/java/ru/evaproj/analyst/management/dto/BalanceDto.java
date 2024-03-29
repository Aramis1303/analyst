package ru.evaproj.analyst.management.dto;

import lombok.Value;
import ru.evaproj.analyst.management.models.ProcessStatus;


@Value
public class BalanceDto {

    private ProcessStatus status;

    private Long timestamp;

    // баланс
    private Double balance;
    // собственные средства
    private Double equity;
    //совокупная плавающий убыток
    private Double margin;
    //совокупная плавающая прибыль
    private Double floatProfit;
    // свободные средства, не участвующие в залоге
    private Double freeMargin;

}
