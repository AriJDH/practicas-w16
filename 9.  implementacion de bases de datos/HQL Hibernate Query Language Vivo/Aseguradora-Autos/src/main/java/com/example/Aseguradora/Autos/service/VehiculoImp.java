package com.example.Aseguradora.Autos.service;

import com.example.Aseguradora.Autos.dto.VehiculoPatenteDto;
import com.example.Aseguradora.Autos.dto.VehiculoPatenteMarcaDto;
import com.example.Aseguradora.Autos.dto.VehiculoPatenteMarcaModeloDto;
import com.example.Aseguradora.Autos.dto.VehiculoSiniestroDto;
import com.example.Aseguradora.Autos.repository.ISeniestroRepository;
import com.example.Aseguradora.Autos.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoImp implements IVehiculo{

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Autowired
    ISeniestroRepository seniestroRepository;

    @Override
    public List<VehiculoPatenteDto> mostrarPatente() {
        List<VehiculoPatenteDto> vehiculoPatenteDtos = vehiculoRepository.mostrarPatentes().stream()
                .map(vehiculo -> new VehiculoPatenteDto(vehiculo)).collect(Collectors.toList());
        return vehiculoPatenteDtos;
    }

    @Override
    public List<VehiculoPatenteDto> mostrarPatentePorRuedas() {
        List<VehiculoPatenteDto> vehiculoPatenteDtos = vehiculoRepository.mostrarPatentePorRuedasYAnio().stream()
                .map(vehiculo-> new VehiculoPatenteDto(vehiculo)).collect(Collectors.toList());
        return vehiculoPatenteDtos;
    }

    @Override
    public List<VehiculoPatenteMarcaDto> mostrarPatenteYMarca() {
        List<VehiculoPatenteMarcaDto> vehiculoPatenteMarcaDtos = vehiculoRepository.mostrarPatenteYMarca().stream()
                .map(vehiculo->new VehiculoPatenteMarcaDto(vehiculo.getPatente(), vehiculo.getMarca()))
                .collect(Collectors.toList());
        return vehiculoPatenteMarcaDtos;
    }

    @Override
    public List<VehiculoPatenteMarcaModeloDto> mostrarPatenteMarcaYModelo() {
        List<VehiculoPatenteMarcaModeloDto> vehiculoPatenteMarcaModeloDtos = vehiculoRepository.mostrarPatenteaMarcayModelo()
                .stream().map(vehiculo -> new VehiculoPatenteMarcaModeloDto(vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo()))
                .collect(Collectors.toList());
        return vehiculoPatenteMarcaModeloDtos;
    }

    @Override
    public List<VehiculoSiniestroDto> mostrarPorPerdidaEconomica() {
        Integer maximo = seniestroRepository.mostrarPorPerdidaEconomica();
        List<VehiculoSiniestroDto> vehiculoSiniestroDtos = vehiculoRepository.mostrarPatenteaMarcayModelo().stream()
                .map(vehiculo -> new VehiculoSiniestroDto(new VehiculoPatenteMarcaModeloDto(vehiculo.getPatente(),vehiculo.getMarca(),vehiculo.getModelo()),maximo))
                .collect(Collectors.toList());
        return vehiculoSiniestroDtos;
    }

}
