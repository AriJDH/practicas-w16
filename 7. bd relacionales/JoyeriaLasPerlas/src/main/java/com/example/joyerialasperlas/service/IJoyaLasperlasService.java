package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.dto.NewJoyaDto;
import com.example.joyerialasperlas.dto.ResponseIdDto;
import com.example.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaLasperlasService {

    public List<JoyaDto> getJoyas();

    public ResponseIdDto saveJoya(NewJoyaDto joya);

    public void logicDeleteJoya(long id);

    public JoyaDto editJoya(long id, JoyaDto joyaEdit);

}
