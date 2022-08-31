package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.JoyaUpdateDTO;
import com.example.joyeria.exceptions.IdError;

import java.util.List;

public interface JoyaService {
    String createNewJoya(JoyaDTO joyaDTO);
    List<JoyaUpdateDTO> getAll();
    JoyaDTO getById(int id) throws IdError ;
    String deleteById(int id) throws IdError ;
    JoyaUpdateDTO updateById(int id, JoyaUpdateDTO joyaUpdateDTO)throws IdError;
}
