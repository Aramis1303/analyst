package ru.evaproj.analyst.management.service;

import ru.evaproj.analyst.management.dto.ManagementDto;

import java.util.List;

public interface ManagementService {

    List<ManagementDto> getOpenedDealQuery();

    ManagementDto getLastOpenedDealQuery(String marketName);

    ManagementDto sellQuery(String marketName);

    ManagementDto buyQuery(String marketName);

    ManagementDto cancelQuery(Long timestamp);

    ManagementDto closeDeal(String marketName);
}
