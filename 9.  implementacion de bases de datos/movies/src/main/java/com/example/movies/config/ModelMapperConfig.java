package com.example.movies.config;

import com.example.movies.dto.ActorDTO;
import com.example.movies.model.Actor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        //Setup mapper
        TypeMap<Actor, ActorDTO> propertyMapper = modelMapper.createTypeMap(Actor.class, ActorDTO.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getFavoriteMovie().getId(),ActorDTO::setFavoriteMovie)
        );


        return modelMapper;
    }


}
