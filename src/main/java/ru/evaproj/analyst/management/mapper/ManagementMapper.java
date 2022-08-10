package ru.evaproj.analyst.management.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.evaproj.analyst.management.dto.ManagementDto;
import ru.evaproj.analyst.management.entity.ManagementEntity;

@Component
@Mapper(componentModel = "spring")
public interface ManagementMapper {

    ManagementEntity dtoToEntity(ManagementDto dto);
    ManagementDto entityToDto(ManagementEntity entity);

}
