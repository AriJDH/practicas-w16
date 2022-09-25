package com.vehiculos.seguro.service;

import com.vehiculos.seguro.dto.VehiculoDTO;
import com.vehiculos.seguro.dto.VehiculoPatenteDTO;
import com.vehiculos.seguro.models.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoPatenteDTO>  listAllByPatente();
    List<VehiculoDTO> findAllOrderByAnioFabricacion();
    List<VehiculoDTO> findAllWith4WheelsMadeThisYear();
}
