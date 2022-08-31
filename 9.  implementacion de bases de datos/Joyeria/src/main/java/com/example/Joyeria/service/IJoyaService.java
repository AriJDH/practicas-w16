package com.example.Joyeria.service;

import com.example.Joyeria.dto.JoyaDTO;
import com.example.Joyeria.dto.MessageDTO;
import com.example.Joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    public MessageDTO saveJoya(Joya j);
    public List<JoyaDTO> getJoyas();
    public MessageDTO deleteJoya(int id);
    public JoyaDTO editJoya(int id, JoyaDTO j);
}
