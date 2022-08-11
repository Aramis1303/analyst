package ru.evaproj.analyst.management.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evaproj.analyst.management.dto.BalanceDto;
import ru.evaproj.analyst.management.entity.BalanceEntity;
import ru.evaproj.analyst.management.models.BalanceQueryStatusEnum;
import ru.evaproj.analyst.management.repo.BalanceRepo;

import java.util.Date;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    BalanceRepo balanceRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public BalanceDto getBalance() {

        return modelMapper.map(balanceRepo.findTopOrderByTimestamp(), BalanceDto.class);
    }

    @Override
    public BalanceDto sendBalanceQuery() {

        BalanceEntity entity = new BalanceEntity();
        entity.setTimestamp(new Date().getTime() / 1000);
        entity.setStatus(BalanceQueryStatusEnum.REQUEST);

        balanceRepo.save(entity);

        return modelMapper.map(entity, BalanceDto.class);
    }

}
