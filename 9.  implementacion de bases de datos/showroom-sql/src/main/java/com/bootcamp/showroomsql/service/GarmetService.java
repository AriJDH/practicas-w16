package com.bootcamp.showroomsql.service;

import com.bootcamp.showroomsql.dto.GarmetDto;
import com.bootcamp.showroomsql.entity.Garmet;
import com.bootcamp.showroomsql.repository.IGarmetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GarmetService implements IGarmetService {

    @Autowired
    IGarmetRepository garmetRepository;

    private final ModelMapper modelMapper;

    public GarmetService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public GarmetDto save(GarmetDto garmetDto) {
        Garmet result = garmetRepository.save(modelMapper.map(garmetDto, Garmet.class));

        return modelMapper.map(result, GarmetDto.class);
    }
}
