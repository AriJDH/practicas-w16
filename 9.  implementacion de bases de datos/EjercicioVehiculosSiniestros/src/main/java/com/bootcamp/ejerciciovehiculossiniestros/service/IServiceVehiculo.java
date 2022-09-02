package com.bootcamp.ejerciciovehiculossiniestros.service;

import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoPatenteAndMarcaDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoPatenteDto;

import java.util.List;

public interface IServiceVehiculo {

    void crearVehiculo(VehiculoDto vehiculoDto);

    List<VehiculoPatenteDto> obtenerTodasLasPatentes();

    VehiculoDto obtenerVehiculoPorPatente(String patente);

    public List<VehiculoPatenteAndMarcaDto> obtenerOrdenado();
    public List<VehiculoPatenteDto> obtener4RuedasYAñoCorriente();
}
