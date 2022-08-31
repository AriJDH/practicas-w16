package com.implementacionbd.Joyeria.service;

import com.implementacionbd.Joyeria.dto.JoyaDTO;
import com.implementacionbd.Joyeria.dto.ResponseDTO;
import com.implementacionbd.Joyeria.dto.ResponseJoyaDTO;
import com.implementacionbd.Joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    ResponseDTO save(JoyaDTO joyaDTO);
    List<ResponseJoyaDTO> getJoyas();
    ResponseJoyaDTO getJoya(Long id);
    ResponseDTO deleteJoya(Long id);
    ResponseDTO editJoya(Long id, JoyaDTO joyaDTO);
}
