package com.vehiculos.seguro.service;

import com.vehiculos.seguro.dto.VehiculoPatenteDTO;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoPatenteDTO>  listAllByPatente();
}
