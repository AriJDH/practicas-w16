package com.example.lasPerlas.service;

import com.example.lasPerlas.dto.JoyaDTO;
import com.example.lasPerlas.entity.Joya;

import java.util.List;

public interface IJoyeriaService {

    public List<JoyaDTO> find ();

    public JoyaDTO deleteJoya(Long id);

    public JoyaDTO findJoyaById(Long id);

    public JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO);

    public JoyaDTO createJoya(JoyaDTO joyaDTO);
}
