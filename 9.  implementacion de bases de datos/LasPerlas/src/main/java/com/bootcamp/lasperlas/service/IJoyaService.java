package com.bootcamp.lasperlas.service;

import com.bootcamp.lasperlas.dto.request.JoyaDTO;
import com.bootcamp.lasperlas.dto.request.JoyaUpdateDTO;
import com.bootcamp.lasperlas.dto.response.JoyaIdentidicadorDTO;
import com.bootcamp.lasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

  JoyaIdentidicadorDTO crearJoya(JoyaDTO joyaDTO);
  List<JoyaDTO> listadoJoya();
  void eliminar(Long id);
  JoyaUpdateDTO editarJoya(JoyaUpdateDTO joyaDTO, Long id);

}
