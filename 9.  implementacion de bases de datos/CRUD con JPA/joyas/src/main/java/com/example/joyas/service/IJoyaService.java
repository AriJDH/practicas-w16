package com.example.joyas.service;

import com.example.joyas.dto.JoyaDto;
import com.example.joyas.dto.MensajeDto;

import java.util.List;

public interface IJoyaService {

    public List<JoyaDto> getAllJewerly();
    public JoyaDto getJewerlyById(Long id);
    public MensajeDto saveJewerly(JoyaDto joyaDto);
    public JoyaDto updateJoya(JoyaDto joyaDto,Long id);
    public void deleteJewerly(Long id);
}
