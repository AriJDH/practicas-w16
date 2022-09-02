package com.bootcamp.ejerciciovehiculossiniestros.service;

import com.bootcamp.ejerciciovehiculossiniestros.dto.SiniestroDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoMPMDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoSiniestroDto;

import java.util.List;

public interface IServiceSiniestro {
    public SiniestroDto obtenerSiniestro(Long id);

    void reportarSiniestro(SiniestroDto siniestroDto);
    List<VehiculoMPMDto> obtenerMarcaModeloYPatenteByPerdida();

    public VehiculoSiniestroDto obtenerMarcaModeloYPatenteTotalPerdida();
}
