package com.example.springconcesionariadeautos.service;

import com.example.springconcesionariadeautos.dto.VehiculoDTO;
import com.example.springconcesionariadeautos.dto.VehiculoSinServiceDTO;
import com.example.springconcesionariadeautos.entity.Vehiculo;
import com.example.springconcesionariadeautos.repository.IVehiculoRepository;
import com.example.springconcesionariadeautos.util.VehiculoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{
    @Autowired
    IVehiculoRepository vehiculoRepository;

    public VehiculoDTO agregarVehiculo(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = VehiculoMapper.getVehiculo(vehiculoDTO);
        this.vehiculoRepository.agregarVehiculo(vehiculo);
        if(this.vehiculoRepository.obtenerVehiculos().size() != vehiculo.getId()){
            return null;
        }

        return vehiculoDTO;
    }

    public VehiculoDTO obtenerVehiculo(int id){
        Vehiculo vehiculoEncontrado = this.vehiculoRepository.obtenerVehiculo(id);
        if(vehiculoEncontrado == null){
            return null;
        }

        return VehiculoMapper.getVehiculoDTO(vehiculoEncontrado);
    }

    public List<VehiculoSinServiceDTO> obtenerVehiculosUsados(){
        List<Vehiculo> listaDeVehiculosUsados = this.vehiculoRepository.obtenerVehiculos().stream()
                                                .filter(vehiculo -> vehiculo.getNumberOfKilometers() > 0L).collect(Collectors.toList());

        return VehiculoMapper.getVehiculoSinServiceDTOList(listaDeVehiculosUsados);
    }

    public List<VehiculoDTO> obtenerListaDeVehiculosSegunFechaDeFabricacion(Date fechaDesde, Date fechaHasta){
        List<Vehiculo> listaDeVehiculos = this.vehiculoRepository.obtenerVehiculos()
                                            .stream()
                                            .filter(vehiculo -> fechaDesde.before(vehiculo.getManufacturingDate()) && fechaHasta.after(vehiculo.getManufacturingDate()))
                                            .collect(Collectors.toList());

        return VehiculoMapper.getVehiculoDTOList(listaDeVehiculos);
    }

    public List<VehiculoDTO> obtenerListaDeVehiculosSegunPrecio(double precioDesde, double precioHasta){
        List<Vehiculo> listaDeVehiculos = this.vehiculoRepository.obtenerVehiculos()
                                            .stream()
                                            .filter(vehiculo -> precioDesde <= vehiculo.getPrice() && vehiculo.getPrice() <= precioHasta)
                                            .collect(Collectors.toList());

        return VehiculoMapper.getVehiculoDTOList(listaDeVehiculos);
    }
}
