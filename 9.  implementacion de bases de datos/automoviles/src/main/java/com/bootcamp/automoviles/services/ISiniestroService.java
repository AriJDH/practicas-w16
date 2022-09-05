package com.bootcamp.automoviles.services;

import com.bootcamp.automoviles.dto.SiniestroDTO;
import com.bootcamp.automoviles.dto.Siniestro_DTO;

import java.util.List;

public interface ISiniestroService {
    Siniestro_DTO create(Siniestro_DTO siniestroDTO);
    List<SiniestroDTO> find();
}
