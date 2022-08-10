package ru.evaproj.analyst.management.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.evaproj.analyst.management.dto.BalanceDto;
import ru.evaproj.analyst.management.entity.BalanceEntity;

@Component
@Mapper(componentModel = "spring")
public interface BalanceMapper {

    BalanceEntity dtoToEntity (BalanceDto dto);
    BalanceDto entityToDto (BalanceEntity entity);
}
