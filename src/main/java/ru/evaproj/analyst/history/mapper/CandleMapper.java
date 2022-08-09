package ru.evaproj.analyst.history.mapper;


import org.mapstruct.Mapper;
import ru.evaproj.analyst.history.dto.CandleListDto;
import ru.evaproj.analyst.history.entity.CandleEntity;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CandleMapper {

    List<CandleEntity> dtoToEntity(CandleListDto dtoList);

    CandleListDto entityToDto(List<CandleEntity> entityList);

}
