package com.bootcamp.automoviles.services;

import com.bootcamp.automoviles.dto.VehiculoDTO;
import com.bootcamp.automoviles.dto.VehiculoMarcaDTO;
import com.bootcamp.automoviles.dto.VehiculoPatenteDTO;
import com.bootcamp.automoviles.dto.VehiculoSiniestroDTO;

import java.util.List;
import java.util.Map;

public interface IVehiculoService {
    VehiculoDTO create(VehiculoDTO vehiculoDTO);
    List<VehiculoDTO> find();
    List<VehiculoPatenteDTO> findPatentes();
    List<VehiculoMarcaDTO> findPatenteYMarca();
    List<VehiculoPatenteDTO> findMoreThan4Wheels();
    List<VehiculoPatenteDTO> findLostMoreThan10000();
    List<VehiculoSiniestroDTO> findTotales();
}
