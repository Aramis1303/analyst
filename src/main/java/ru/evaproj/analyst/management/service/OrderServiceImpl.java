package ru.evaproj.analyst.management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evaproj.analyst.management.dto.OrderDto;
import ru.evaproj.analyst.management.entity.OrderEntity;
import ru.evaproj.analyst.management.models.OrderType;
import ru.evaproj.analyst.management.models.ProcessStatus;
import ru.evaproj.analyst.management.repo.OrderRepo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    @Transactional
    public List<OrderDto> getOpenedDealQuery() {

        return Stream.concat(
                orderRepo.findByOrderTypeAndStatusOrder(OrderType.BUY, ProcessStatus.OPENED).stream(),
                orderRepo.findByOrderTypeAndStatusOrder(OrderType.SELL, ProcessStatus.OPENED).stream()
        ).collect(Collectors.toList())
                .stream()
                .map(e -> modelMapper.map(e, OrderDto.class))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public List<OrderDto> getPerformedDealQuery() {

        return Stream.concat(
                orderRepo.findByOrderTypeAndStatusOrder(OrderType.BUY, ProcessStatus.PERFORMED).stream(),
                orderRepo.findByOrderTypeAndStatusOrder(OrderType.SELL, ProcessStatus.PERFORMED).stream()
        ).collect(Collectors.toList())
                .stream()
                .map(e -> modelMapper.map(e, OrderDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderDto> getLastSeveralClosed(String marketName, Long limit) {

        return orderRepo.findTopByOrderTypeAndStatus(
                marketName,
                ProcessStatus.CLOSED,
                limit
        )
                .stream()
                .map(e -> modelMapper.map(e, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getLastOpenedDealQuery(String marketName) {

        return modelMapper.map(
                orderRepo.findTopByStatusAndMarketNameOrderByTimestamp(
                        ProcessStatus.OPENED,
                        marketName
                ),
                OrderDto.class);
    }

    @Override
    public OrderDto sellQuery(String marketName) {
        OrderEntity entity = new OrderEntity();
        entity.setMarketName(marketName);
        entity.setOrderType(OrderType.SELL);
        entity.setStatus(ProcessStatus.REQUESTED);
        entity.setTimestamp(new Date().getTime() / 1000);

        orderRepo.save(entity);

        return modelMapper.map(entity, OrderDto.class);
    }

    @Override
    public OrderDto buyQuery(String marketName) {

        OrderEntity entity = new OrderEntity();
        entity.setMarketName(marketName);
        entity.setOrderType(OrderType.BUY);
        entity.setStatus(ProcessStatus.REQUESTED);
        entity.setTimestamp(new Date().getTime() / 1000);

        orderRepo.save(entity);

        return modelMapper.map(entity, OrderDto.class);
    }

    @Override
    @Transactional
    public OrderDto cancelQuery(Long timestamp) {

        OrderEntity entity = orderRepo.findByTimestamp(timestamp);

        if (entity.getStatus().equals(ProcessStatus.REQUESTED) || entity.getStatus().equals(ProcessStatus.OPENED)) {
            entity.setStatus(ProcessStatus.CANCELING);
            orderRepo.save(entity);
        }

        return modelMapper.map(entity, OrderDto.class);
    }

    @Override
    @Transactional
    public OrderDto closeDeal(String marketName) {

        // Ищем последний исполненный ордер выполненный по маркету.
        OrderEntity entity = orderRepo.findTopByStatusAndMarketNameOrderByTimestamp(ProcessStatus.PERFORMED, marketName);
        entity.setStatus(ProcessStatus.CLOSING);
        orderRepo.save(entity);

        return modelMapper.map(entity, OrderDto.class);
    }
}
