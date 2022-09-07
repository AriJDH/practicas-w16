package com.example.Aseguradora.Autos.service;

import com.example.Aseguradora.Autos.dto.VehiculoPatenteDto;
import com.example.Aseguradora.Autos.dto.VehiculoPatenteMarcaDto;
import com.example.Aseguradora.Autos.dto.VehiculoPatenteMarcaModeloDto;
import com.example.Aseguradora.Autos.dto.VehiculoSiniestroDto;

import java.util.List;

public interface IVehiculo {

    List<VehiculoPatenteDto> mostrarPatente();

    List<VehiculoPatenteDto> mostrarPatentePorRuedas();

    List<VehiculoPatenteMarcaDto> mostrarPatenteYMarca();

    List<VehiculoPatenteMarcaModeloDto> mostrarPatenteMarcaYModelo();

    List<VehiculoSiniestroDto> mostrarPorPerdidaEconomica();

}
