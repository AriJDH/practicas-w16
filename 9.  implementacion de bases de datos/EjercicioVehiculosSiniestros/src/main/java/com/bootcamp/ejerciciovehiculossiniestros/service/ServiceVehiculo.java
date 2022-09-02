package com.bootcamp.ejerciciovehiculossiniestros.service;

import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoPatenteAndMarcaDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoPatenteDto;
import com.bootcamp.ejerciciovehiculossiniestros.model.Vehiculo;
import com.bootcamp.ejerciciovehiculossiniestros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceVehiculo implements IServiceVehiculo {

    @Autowired
    IVehiculoRepository IVehiculoRepository;

    public ServiceVehiculo() {
        this.mapper = new ModelMapper();
    }

    final ModelMapper mapper;


    @Override
    public void crearVehiculo(VehiculoDto vehiculoDto) {
        IVehiculoRepository.save(mapper.map(vehiculoDto, Vehiculo.class));
    }

    @Override
    public List<VehiculoPatenteDto> obtenerTodasLasPatentes() {
        List<String> patentes = IVehiculoRepository.obtenerPatentes();

        return patentes.stream().map(VehiculoPatenteDto::new).collect(Collectors.toList());
    }

    @Override
    public VehiculoDto obtenerVehiculoPorPatente(String patente) {
        return mapper.map(IVehiculoRepository.obtenerVehiculoPorPatente(patente), VehiculoDto.class);

    }

    @Override
    public List<VehiculoPatenteAndMarcaDto> obtenerOrdenado() {
        List<Vehiculo> ordenado = IVehiculoRepository.obtenerOrdenado();

        return ordenado.stream()
                .map(v -> new VehiculoPatenteAndMarcaDto(v.getPatente(), v.getMarca()))
                .collect(Collectors.toList());


    }

    @Override
    public List<VehiculoPatenteDto> obtener4RuedasYAñoCorriente() {
        List<Vehiculo> vehiculos = IVehiculoRepository.obtener4RuedasYAñoCorriente();
        return vehiculos.stream().map(e-> new VehiculoPatenteDto(e.getPatente())).collect(Collectors.toList());

    }

}
