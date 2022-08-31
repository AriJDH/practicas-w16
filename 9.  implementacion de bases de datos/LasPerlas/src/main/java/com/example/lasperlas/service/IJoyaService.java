package com.example.lasperlas.service;

import com.example.lasperlas.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {
    List<JoyaDto> listAll();
    JoyaDto create(JoyaDto dto);
    JoyaDto update(JoyaDto dto, Long id);
    void delete(Long id);
}
