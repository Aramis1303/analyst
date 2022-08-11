package ru.evaproj.analyst.management.dto;

import lombok.Value;
import ru.evaproj.analyst.management.models.OrderTypeEnum;
import ru.evaproj.analyst.management.models.OrderStatusEnum;


@Value
public class ManagementDto {

    private Long timestamp;

    private OrderTypeEnum dealType;

    private OrderStatusEnum status;

    private String marketName;

    private Long ticket;
}
