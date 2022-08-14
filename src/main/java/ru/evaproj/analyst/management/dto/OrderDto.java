package ru.evaproj.analyst.management.dto;

import lombok.Value;
import ru.evaproj.analyst.management.models.OrderType;
import ru.evaproj.analyst.management.models.ProcessStatus;


@Value
public class OrderDto {

    private Long timestamp;

    private OrderType dealType;

    private ProcessStatus status;

    private String marketName;

    private Long ticket;
}
