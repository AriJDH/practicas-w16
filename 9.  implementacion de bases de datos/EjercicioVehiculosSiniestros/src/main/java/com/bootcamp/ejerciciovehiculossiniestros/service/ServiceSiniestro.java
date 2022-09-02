package com.bootcamp.ejerciciovehiculossiniestros.service;

import com.bootcamp.ejerciciovehiculossiniestros.dto.SiniestroDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoMPMDto;
import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoSiniestroDto;
import com.bootcamp.ejerciciovehiculossiniestros.model.Siniestro;
import com.bootcamp.ejerciciovehiculossiniestros.model.Vehiculo;
import com.bootcamp.ejerciciovehiculossiniestros.model.VehiculoSiniestro;
import com.bootcamp.ejerciciovehiculossiniestros.repository.ISiniestroRepository;
import com.bootcamp.ejerciciovehiculossiniestros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSiniestro implements IServiceSiniestro {

    public ServiceSiniestro() {
        this.mapper = new ModelMapper();
    }

    @Autowired
    ISiniestroRepository siniestroRepository;

    @Autowired
    IVehiculoRepository vehiculoRepository;

    final ModelMapper mapper;


    @Override
    public SiniestroDto obtenerSiniestro(Long id) {

        return mapper.map(siniestroRepository.findById(id), SiniestroDto.class);
    }

    @Override
    public void reportarSiniestro(SiniestroDto siniestroDto) {

        Vehiculo vehiculo = vehiculoRepository.obtenerVehiculoPorPatente(siniestroDto.getPatente());

        Siniestro siniestro = mapper.map(siniestroDto, Siniestro.class);
        siniestro.setVehiculo(vehiculo);
        siniestroRepository.save(siniestro);

    }
    @Override
    public List<VehiculoMPMDto> obtenerMarcaModeloYPatenteByPerdida() {
        List<Vehiculo> vehiculos = siniestroRepository.obtenerMarcaModeloYPatenteByPerdida();
        return vehiculos.stream()
                .map(e -> new VehiculoMPMDto(e.getPatente(), e.getMarca(), e.getModelo()))
                .collect(Collectors.toList());
    }

    @Override
    public VehiculoSiniestroDto obtenerMarcaModeloYPatenteTotalPerdida(){
        Double totalPerdida = siniestroRepository.obtenerMarcaModeloYPatenteTotalPerdida();
       List<Vehiculo> vehiculos= siniestroRepository.obtenerMarcaModeloYPatenteByPerdida();

        List<VehiculoMPMDto> mpm=vehiculos.stream()
                .map(e -> new VehiculoMPMDto(e.getPatente(), e.getMarca(), e.getModelo()))
                .collect(Collectors.toList());

        return new VehiculoSiniestroDto(mpm,totalPerdida);

    }

}
