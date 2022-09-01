package com.miniseries.services;

import com.miniseries.dto.JoyaDTO;

import java.util.List;

public interface IJoyaService {

    JoyaDTO create(JoyaDTO joyaDTO);

    JoyaDTO findById(Long id);

    List<JoyaDTO> find();

    JoyaDTO delete(Long id);

    JoyaDTO update(Long id, JoyaDTO joyaDTO);

}
