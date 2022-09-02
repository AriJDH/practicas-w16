package com.example.ejerciciosiniestros.service;

import com.example.ejerciciosiniestros.dto.SiniestroDTO;
import com.example.ejerciciosiniestros.model.Siniestro;

import java.util.List;

public interface ISiniestroService {

    Siniestro findSiniestroById(long id);

    List<Siniestro> findAllSiniestros   ();

    Siniestro saveSiniestro(SiniestroDTO siniestroDTO);

    void deleteSiniestro(long id);

    Siniestro updateSiniestro(Siniestro siniestro);
}
