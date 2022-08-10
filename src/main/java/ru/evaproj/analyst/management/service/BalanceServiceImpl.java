package ru.evaproj.analyst.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.management.dto.BalanceDto;
import ru.evaproj.analyst.management.entity.BalanceEntity;
import ru.evaproj.analyst.management.mapper.BalanceMapper;
import ru.evaproj.analyst.management.models.BalanceQueryStatusEnum;
import ru.evaproj.analyst.management.repo.BalanceRepo;

import java.util.Date;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    BalanceRepo balanceRepo;

    @Autowired
    BalanceMapper balanceMapper;

    @Override
    public BalanceDto getBalance() {

        return balanceMapper.entityToDto(balanceRepo.findTopOrderByTimestamp());
    }

    @Override
    public BalanceDto sendBalanceQuery() {

        BalanceEntity entity = new BalanceEntity();
        entity.setTimestamp(new Date().getTime() / 1000);
        entity.setStatus(BalanceQueryStatusEnum.REQUEST);

        balanceRepo.save(entity);

        return balanceMapper.entityToDto(entity);
    }

}
