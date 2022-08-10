package ru.evaproj.analyst.management.dto;

import lombok.Value;
import ru.evaproj.analyst.management.models.DealTypeEnum;
import ru.evaproj.analyst.management.models.ManagementDealStatusEnum;


@Value
public class ManagementDto {

    private Long timestamp;

    private DealTypeEnum dealType;

    private ManagementDealStatusEnum status;

    private String marketName;

}
