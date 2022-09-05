package com.compound.compoundbuy.service;

import com.compound.compoundbuy.DTO.PucharseCreateDTO;
import com.compound.compoundbuy.dao.IPucharseDao;
import com.compound.compoundbuy.entity.Pucharse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PucharseServiceImpl implements IPucharseService {

    @Autowired
    IPucharseDao pucharseDao;

    private final ModelMapper modelMapper;

    public PucharseServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public PucharseCreateDTO create(PucharseCreateDTO pucharseCreateDTO) {

        Pucharse pucharse = pucharseDao.save(modelMapper.map(pucharseCreateDTO, Pucharse.class));

        return modelMapper.map(pucharse, PucharseCreateDTO.class);
    }
}
