package com.kadaijin.kadaijin.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConverter {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
