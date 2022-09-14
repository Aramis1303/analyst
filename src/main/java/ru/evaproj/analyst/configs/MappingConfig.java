package ru.evaproj.analyst.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.evaproj.analyst.history.mapper.CandleMapper;
import ru.evaproj.analyst.history.mapper.CandleMapperImpl;

@Configuration
public class MappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
