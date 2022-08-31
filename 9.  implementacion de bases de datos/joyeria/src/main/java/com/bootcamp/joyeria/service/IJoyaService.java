package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.JoyaDto;
import com.bootcamp.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    List<Joya> getJoyas();
    void saveJoya(JoyaDto joya);
    void deleteJoyaBy(Long id);
    Joya findJoyaById(Long id);
    Joya UpdateJoyaById(Long id, JoyaDto dto);
}
