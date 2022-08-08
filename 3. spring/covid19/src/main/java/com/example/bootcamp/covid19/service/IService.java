package com.example.bootcamp.covid19.service;

import com.example.bootcamp.covid19.dto.PersonaDTO;
import com.example.bootcamp.covid19.dto.SintomaDTO;
import com.example.bootcamp.covid19.model.Sintoma;

import java.util.List;

public interface IService {
    public List<SintomaDTO> getAllSympton();

    public SintomaDTO getSymptonByName(String name);

    public List<PersonaDTO> getRisksPersons();

}
