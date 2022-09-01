package com.joyeria.lasperlas.service;

import com.joyeria.lasperlas.DTOs.JoyaDTO;
import com.joyeria.lasperlas.DTOs.JoyaUpdateDTO;

import java.util.List;

public interface IJoyaService {
    Long create(JoyaDTO joyaCreateDTO);

    List<JoyaDTO> getAll();

    boolean delete(Long id);

    JoyaUpdateDTO update(JoyaDTO joyaDTO, Long id);

}
