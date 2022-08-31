package com.myapp.lasperlas.services;

import com.myapp.lasperlas.dto.JoyaDTO;
import com.myapp.lasperlas.model.Joya;
import com.myapp.lasperlas.repository.IJoyaRepository;

import java.util.List;

public interface IJoyaService {

    String saveJoya(JoyaDTO joyaDTO);

    List<JoyaDTO> getAll();

    String delete(Long nroIdentificatorio);

    JoyaDTO getById(Long nroIdentificatorio);

    String updateJoya(Long id, JoyaDTO joyaDTO);



}
