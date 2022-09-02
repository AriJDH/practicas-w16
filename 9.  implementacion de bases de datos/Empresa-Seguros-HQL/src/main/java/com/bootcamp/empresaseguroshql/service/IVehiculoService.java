package com.bootcamp.empresaseguroshql.service;

import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteDto;
import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteMarcaDto;
import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteMarcaModeloDto;

import java.util.List;

public interface IVehiculoService {

    List<VehiculoPatenteDto> encontrarPatenteVehiculos();

    List<VehiculoPatenteMarcaDto> encontrarPatenteMarcaVehiculos();

    List<VehiculoPatenteDto> encontrarVehiculoMas4RuedasAnioEnCurso();

    List<VehiculoPatenteMarcaModeloDto> encontrarVehiculosPerdidaMayor10000();
}
