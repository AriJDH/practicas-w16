package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.MarcaYPatenteVehiculoDto;
import com.bootcamp.seguros.dto.PatenteDto;
import com.bootcamp.seguros.dto.VehiculoDtoResponse;
import com.bootcamp.seguros.model.Vehiculo;
import com.bootcamp.seguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.aspectj.util.LangUtil.split;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    IVehiculoRepository iVehiculoRepository;

    private ModelMapper modelMapper;

    public VehiculoService() {
        this.modelMapper = new ModelMapper();
    }


    @Override
    public List<VehiculoDtoResponse> getAllVehiculos() {
        List<Vehiculo> vehiculos = iVehiculoRepository.getAllVehiculos();
        return vehiculos.stream().map(x->modelMapper.map(x, VehiculoDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<MarcaYPatenteVehiculoDto> getAllPatentesYMarcasVehiculos() {
        List<String> vehiculos = iVehiculoRepository.getAllPatentesYMarcasVehiculos();
        return vehiculos.stream().map(x->{
            var aux = x.split(",");
            return new MarcaYPatenteVehiculoDto(aux[0],aux[1]);
    }).collect(Collectors.toList());
    }

    @Override
    public List<PatenteDto> getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(Integer anioFabricacion) {
        List<String> vehiculos = iVehiculoRepository.getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(anioFabricacion);
        return vehiculos.stream().map(x->{
            return new PatenteDto();
        }).collect(Collectors.toList());

    }


}
