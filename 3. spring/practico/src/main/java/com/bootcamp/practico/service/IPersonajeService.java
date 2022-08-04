package com.bootcamp.practico.service;

import com.bootcamp.practico.dto.RequestPersonajeDTO;
import com.bootcamp.practico.dto.ResponsePersonajeDto;

import java.util.List;

public interface IPersonajeService {
    public void cargaPersonajes(List<RequestPersonajeDTO> body);
    public List<ResponsePersonajeDto> getPersonajesByName(String name);
}
