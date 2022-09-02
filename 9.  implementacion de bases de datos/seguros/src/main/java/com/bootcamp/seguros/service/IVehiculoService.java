package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.ResponseApiDTO;
import com.bootcamp.seguros.dto.ResponsePatenteDTO;
import com.bootcamp.seguros.dto.ResponsePatenteMarcaDTO;
import com.bootcamp.seguros.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService {

    List<ResponsePatenteDTO> findAllPatentes();

    List<ResponsePatenteMarcaDTO> findAllOrderByDate();

    ResponseApiDTO createVehiculo(VehiculoDTO vehiculoDTO);


}
