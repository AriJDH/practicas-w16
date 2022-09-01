package com.tomas.joyeria.service;

import com.tomas.joyeria.dto.JoyaDTO;
import com.tomas.joyeria.dto.ListaJoyaDTO;
import com.tomas.joyeria.dto.RespuestaActualizadoDTO;
import com.tomas.joyeria.dto.RespuestaCreadoDTO;

public interface IJoyeriaService {

    RespuestaCreadoDTO crearJoya(JoyaDTO joyaDTO);
    ListaJoyaDTO listarJoya();
    void eliminarJoya(Long id);
    RespuestaActualizadoDTO actualizarJoya(Long id, JoyaDTO joyaDTO);

}
