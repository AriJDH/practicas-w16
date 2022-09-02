package com.example.joyeriameli.service;

import com.example.joyeriameli.dto.MessageDto;
import com.example.joyeriameli.model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getJoya();
    public MessageDto saveJoya (Joya joya);
    public MessageDto deleteJoya (Long id);
    public MessageDto findJoya (Long id);
    public MessageDto deleteJoyaLogic (Long id);
    public MessageDto updateJoya (Long id,String newName,Long newPeso);

}
