package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.MarcaYPatenteVehiculoDto;
import com.bootcamp.seguros.dto.PatenteDto;
import com.bootcamp.seguros.dto.VehiculoDtoResponse;
import com.bootcamp.seguros.dto.VehiculoSiniestro;
import com.bootcamp.seguros.model.Siniestro;
import com.bootcamp.seguros.model.Vehiculo;
import com.bootcamp.seguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    IVehiculoRepository vehiculoRepository;

    private ModelMapper modelMapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {

        this.vehiculoRepository = vehiculoRepository;

        this.modelMapper = new ModelMapper();
        var v1 = new Vehiculo(null, "ert717", "suzuki", "fun", 2004, 4, new ArrayList<>());
        var v2 = new Vehiculo(null, "djk117", "vw", "golf gti", 2001, 4, new ArrayList<>());
        v2.getSiniestros().add(new Siniestro(null, LocalDate.now(), 11000, 1L, v2));

        vehiculoRepository.save(v1);
        vehiculoRepository.save(v2);

    }


    @Override
    public List<VehiculoDtoResponse> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.getAllVehiculos();
        return vehiculos.stream().map(x -> modelMapper.map(x, VehiculoDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<MarcaYPatenteVehiculoDto> getAllPatentesYMarcasVehiculos() {
        List<String> vehiculos = vehiculoRepository.getAllPatentesYMarcasVehiculos();
        return vehiculos.stream().map(x -> {
            var aux = x.split(",");
            return new MarcaYPatenteVehiculoDto(aux[0], aux[1]);
        }).collect(Collectors.toList());
    }

    @Override
    public List<PatenteDto> getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(Integer anioFabricacion) {
        List<String> vehiculos = vehiculoRepository.getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(anioFabricacion);
        return vehiculos.stream().map(x -> {
            return new PatenteDto();
        }).collect(Collectors.toList());

    }

    @Override
    public List<String> vehiculosConperdidaSuperior1000() {
        return vehiculoRepository.getVehiculosConSiniestrosDePerdidaMayorA10000Pesos();

    }

    @Override
    public List<VehiculoSiniestro> vehiculosYCostoFinalPerdidaSuperior1000() {
        var v = vehiculoRepository.getVehiculosConSumaDePerdidasQueSuperaron10000Pesos();
        //To avoid circular json convertion
        v.forEach(elem -> elem.getVehiculo().setSiniestros(null));
        return v;
    }


}
