package com.tomas.concesionaria.service;

import com.tomas.concesionaria.dto.ListaVehiculoDTO;
import com.tomas.concesionaria.dto.VehiculoDTO;
import com.tomas.concesionaria.dto.MensajeDTO;

public interface IConcesionarioService {

    MensajeDTO agregarVehiculo(VehiculoDTO vehiculoDTO);
    ListaVehiculoDTO listarVehiculo();
    VehiculoDTO consultarVehiculo(Long id);

}
