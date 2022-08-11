package ru.evaproj.analyst.management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evaproj.analyst.management.dto.ManagementDto;
import ru.evaproj.analyst.management.entity.ManagementEntity;
import ru.evaproj.analyst.management.models.OrderTypeEnum;
import ru.evaproj.analyst.management.models.OrderStatusEnum;
import ru.evaproj.analyst.management.repo.ManagementRepo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    ManagementRepo managementRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    @Transactional
    public List<ManagementDto> getOpenedDealQuery() {

        return Stream.concat(
                managementRepo.findByDealTypeAndStatusOrder(OrderTypeEnum.BUY, OrderStatusEnum.OPENED).stream(),
                managementRepo.findByDealTypeAndStatusOrder(OrderTypeEnum.SELL, OrderStatusEnum.OPENED).stream()
        ).collect(Collectors.toList())
                .stream()
                .map(e -> modelMapper.map(e, ManagementDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public ManagementDto getLastOpenedDealQuery(String marketName) {

        return modelMapper.map(
                managementRepo.findTopByStatusAndMarketNameOrderByTimestamp(
                        OrderStatusEnum.OPENED,
                        marketName
                ),
                ManagementDto.class);
    }

    @Override
    public ManagementDto sellQuery(String marketName) {
        ManagementEntity entity = new ManagementEntity();
        entity.setMarketName(marketName);
        entity.setDealType(OrderTypeEnum.SELL);
        entity.setStatus(OrderStatusEnum.REQUEST);
        entity.setTimestamp(new Date().getTime() / 1000);

        managementRepo.save(entity);

        return modelMapper.map(entity, ManagementDto.class);
    }

    @Override
    public ManagementDto buyQuery(String marketName) {

        ManagementEntity entity = new ManagementEntity();
        entity.setMarketName(marketName);
        entity.setDealType(OrderTypeEnum.BUY);
        entity.setStatus(OrderStatusEnum.REQUEST);
        entity.setTimestamp(new Date().getTime() / 1000);

        managementRepo.save(entity);

        return modelMapper.map(entity, ManagementDto.class);
    }

    @Override
    @Transactional
    public ManagementDto cancelQuery(Long timestamp) {

        ManagementEntity entity = managementRepo.findByTimestamp(timestamp);

        if (entity.getStatus().equals(OrderStatusEnum.REQUEST) || entity.getStatus().equals(OrderStatusEnum.PENDING)) {
            entity.setDealType(OrderTypeEnum.RECALL);
            managementRepo.save(entity);
        }

        return modelMapper.map(entity, ManagementDto.class);
    }

    @Override
    @Transactional
    public ManagementDto closeDeal(String marketName) {

        ManagementEntity entity = managementRepo.findTopByStatusAndMarketNameOrderByTimestamp(OrderStatusEnum.OPENED, marketName);

        entity.setDealType(OrderTypeEnum.CLOSE);
        managementRepo.save(entity);

        return modelMapper.map(entity, ManagementDto.class);
    }
}
