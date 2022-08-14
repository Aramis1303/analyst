package ru.evaproj.analyst.management.service;

import ru.evaproj.analyst.management.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getOpenedDealQuery();

    List<OrderDto> getPerformedDealQuery();

    List<OrderDto> getLastSeveralClosed(String marketName, Long value);

    OrderDto getLastOpenedDealQuery(String marketName);

    OrderDto sellQuery(String marketName);

    OrderDto buyQuery(String marketName);

    OrderDto cancelQuery(Long timestamp);

    OrderDto closeDeal(String marketName);
}
