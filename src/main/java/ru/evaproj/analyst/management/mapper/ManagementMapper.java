package ru.evaproj.analyst.management.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.evaproj.analyst.management.dto.OrderDto;
import ru.evaproj.analyst.management.entity.OrderEntity;

@Deprecated
@Component
@Mapper(componentModel = "spring")
public interface ManagementMapper {

    OrderEntity dtoToEntity(OrderDto dto);
    OrderDto entityToDto(OrderEntity entity);

}
