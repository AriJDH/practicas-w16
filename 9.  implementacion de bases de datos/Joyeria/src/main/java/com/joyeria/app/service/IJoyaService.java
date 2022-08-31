package com.joyeria.app.service;

import com.joyeria.app.dto.JoyaDto;
import com.joyeria.app.model.Joya;

import java.util.List;

public interface IJoyaService {

    JoyaDto save(Joya joya);

    void delete(Long id) throws Exception;

    List<JoyaDto> getJoyas();

    JoyaDto getJoyaById(Long id);

    JoyaDto update(Long id,Joya joya) throws Exception;


}
