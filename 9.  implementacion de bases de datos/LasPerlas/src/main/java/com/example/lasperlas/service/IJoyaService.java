package com.example.lasperlas.service;

import com.example.lasperlas.dtos.JoyaDto;
import com.example.lasperlas.dtos.MessageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IJoyaService {

    MessageDto saveJoya(JoyaDto joyaDto);
    List<JoyaDto> getJoyas();
    MessageDto deleteJoya(Long id);
    Object updateJoya(Long id, JoyaDto joyaDto);

}
