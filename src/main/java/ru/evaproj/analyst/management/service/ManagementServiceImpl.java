package ru.evaproj.analyst.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evaproj.analyst.management.dto.ManagementDto;
import ru.evaproj.analyst.management.entity.ManagementEntity;
import ru.evaproj.analyst.management.mapper.ManagementMapper;
import ru.evaproj.analyst.management.models.DealTypeEnum;
import ru.evaproj.analyst.management.models.ManagementDealStatusEnum;
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
    ManagementMapper managementMapper;


    @Override
    @Transactional
    public List<ManagementDto> getOpenedDealQuery() {

        return Stream.concat(
                managementRepo.findByDealTypeAndStatusOrder(DealTypeEnum.BUY, ManagementDealStatusEnum.OPENED).stream(),
                managementRepo.findByDealTypeAndStatusOrder(DealTypeEnum.SELL, ManagementDealStatusEnum.OPENED).stream()
        ).collect(Collectors.toList())
                .stream()
                .map(managementMapper::entityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public ManagementDto getLastOpenedDealQuery(String marketName) {

        return managementMapper.entityToDto(
                managementRepo.findTopByStatusAndMarketNameOrderByTimestamp(
                        ManagementDealStatusEnum.OPENED,
                        marketName
                ));
    }

    @Override
    public ManagementDto sellQuery(String marketName) {
        ManagementEntity entity = new ManagementEntity();
        entity.setMarketName(marketName);
        entity.setDealType(DealTypeEnum.SELL);
        entity.setStatus(ManagementDealStatusEnum.REQUEST);
        entity.setTimestamp(new Date().getTime() / 1000);

        managementRepo.save(entity);

        return managementMapper.entityToDto(entity);
    }

    @Override
    public ManagementDto buyQuery(String marketName) {

        ManagementEntity entity = new ManagementEntity();
        entity.setMarketName(marketName);
        entity.setDealType(DealTypeEnum.BUY);
        entity.setStatus(ManagementDealStatusEnum.REQUEST);
        entity.setTimestamp(new Date().getTime() / 1000);

        managementRepo.save(entity);

        return managementMapper.entityToDto(entity);
    }

    @Override
    @Transactional
    public ManagementDto cancelQuery(Long timestamp) {

        ManagementEntity entity = managementRepo.findByTimestamp(timestamp);
        if (entity.getStatus().equals(ManagementDealStatusEnum.REQUEST) || entity.getStatus().equals(ManagementDealStatusEnum.PENDING)) {
            entity.setStatus(ManagementDealStatusEnum.RECALLED);
            managementRepo.save(entity);
        }

        return managementMapper.entityToDto(entity);
    }

    @Override
    @Transactional
    public ManagementDto closeDeal(String marketName) {

        ManagementEntity entity = managementRepo.findTopByStatusAndMarketNameOrderByTimestamp(ManagementDealStatusEnum.OPENED, marketName);
        entity.setDealType(DealTypeEnum.CLOSE);
        managementRepo.save(entity);

        return managementMapper.entityToDto(entity);
    }
}
