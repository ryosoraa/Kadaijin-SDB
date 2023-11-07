package com.kadaijin.kadaijin.configuration;

import com.kadaijin.kadaijin.utils.Paging;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Configurations {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Paging page(){
        return new Paging();
    }



}
