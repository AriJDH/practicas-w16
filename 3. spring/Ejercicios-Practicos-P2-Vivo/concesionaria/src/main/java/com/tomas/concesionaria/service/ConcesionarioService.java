
package com.tomas.concesionaria.service;
import com.tomas.concesionaria.dto.ListaVehiculoDTO;
import com.tomas.concesionaria.dto.VehiculoDTO;
import com.tomas.concesionaria.dto.MensajeDTO;
import com.tomas.concesionaria.mapper.ServicioMapper;
import com.tomas.concesionaria.mapper.VehiculoMapper;
import com.tomas.concesionaria.repository.IServicioRepository;
import com.tomas.concesionaria.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class ConcesionarioService implements IConcesionarioService{

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Autowired
    IServicioRepository serviceRepository;

    @Autowired
    VehiculoMapper vehiculoMapper;

    @Autowired
    ServicioMapper servicioMapper;

    @Override
    public MensajeDTO agregarVehiculo(VehiculoDTO vehiculoDTO){


        Long idServicio = serviceRepository.registrarServicio(servicioMapper.mapearServicio(vehiculoDTO.getServices()));

        vehiculoRepository.registrarVehiculo(vehiculoMapper.mapearVehiculo(vehiculoDTO, idServicio));

        MensajeDTO mensajeDTO = new MensajeDTO();
        mensajeDTO.setTitulo("Registrado");
        mensajeDTO.setMensaje("El vehículo usado fue registrado satisfactoriamente");

        return mensajeDTO;

    }

    @Override
    public ListaVehiculoDTO listarVehiculo() {

        ListaVehiculoDTO listaVehiculoDTO = new ListaVehiculoDTO();

        listaVehiculoDTO.setVehiculo(
                vehiculoRepository.obtenerVehiculo()
                        .stream().map(vehiculo->
                            vehiculoMapper.mapearVehiculoMenosServicioDTO(vehiculo)
                ).collect(Collectors.toList()));

        return listaVehiculoDTO;

    }

    @Override
    public VehiculoDTO consultarVehiculo(Long id) {

        VehiculoDTO vehiculoDTO;
        vehiculoDTO = vehiculoMapper.mapearVehiculoDTO(vehiculoRepository.obtenerVehiculoEspecifico(id));

        Long idServicio = vehiculoRepository.consultarIdServicio(id);

        vehiculoDTO.setServices(servicioMapper.mapearServicioDTO(serviceRepository.obtenerServicio(idServicio)));


        return vehiculoDTO;
    }


}
