package com.example.springconcesionariadeautos.service;

import com.example.springconcesionariadeautos.dto.VehiculoDTO;
import com.example.springconcesionariadeautos.dto.VehiculoSinServiceDTO;
import com.example.springconcesionariadeautos.entity.Vehiculo;
import com.example.springconcesionariadeautos.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{
    @Autowired
    IVehiculoRepository repository;

    public VehiculoDTO agregarVehiculo(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = this.mapperVehiculo(vehiculoDTO);
        this.repository.agregarVehiculo(vehiculo);
        if(this.repository.obtenerVehiculos().size() == vehiculo.getId()){
            return vehiculoDTO;
        }

        return null;
    }

    public VehiculoDTO obtenerVehiculo(int id){
        Vehiculo vehiculoEncontrado = this.repository.obtenerVehiculo(id);

        if(vehiculoEncontrado == null){
            return null;
        }

        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setBrand(vehiculoEncontrado.getBrand());
        vehiculoDTO.setModel(vehiculoEncontrado.getModel());
        vehiculoDTO.setManufacturingDate(vehiculoEncontrado.getManufacturingDate());
        vehiculoDTO.setNumberOfKilometers(vehiculoEncontrado.getNumberOfKilometers());
        vehiculoDTO.setDoors(vehiculoEncontrado.getDoors());
        vehiculoDTO.setPrice(vehiculoEncontrado.getPrice());
        vehiculoDTO.setCurrency(vehiculoEncontrado.getCurrency());
        vehiculoDTO.setServices(vehiculoEncontrado.getServices());
        vehiculoDTO.setCountOfOwners(vehiculoEncontrado.getCountOfOwners());

        return vehiculoDTO;
    }

    public List<VehiculoSinServiceDTO> obtenerUsados(){
        List<Vehiculo> listaDeVehiculosUsados = this.repository.obtenerVehiculos().stream()
                                                .filter(vehiculo -> vehiculo.getNumberOfKilometers() > 0L).collect(Collectors.toList());
        return this.obtenerMapperListaDeVehiculosSinService(listaDeVehiculosUsados);
    }

    public List<VehiculoDTO> obtenerListaDeVehiculosSegunFechaDeFabricacion(Date desde, Date hasta){
        List<Vehiculo> listaDeVehiculos = this.repository.obtenerVehiculos().stream()
                .filter(vehiculo -> desde.before(vehiculo.getManufacturingDate()) && hasta.after(vehiculo.getManufacturingDate()))
                .collect(Collectors.toList());

        return obtenerMapperVehiculos(listaDeVehiculos);
    }

    public List<VehiculoDTO> obtenerListaDeVehiculosSegunPrecio(double desde, double hasta){
        List<Vehiculo> listaDeVehiculos = this.repository.obtenerVehiculos().stream()
                .filter(vehiculo -> desde <= vehiculo.getPrice() && vehiculo.getPrice() <= hasta)
                .collect(Collectors.toList());

        return obtenerMapperVehiculos(listaDeVehiculos);
    }

    private Vehiculo mapperVehiculo(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = new Vehiculo(0,
                                        vehiculoDTO.getBrand(),
                                        vehiculoDTO.getModel(),
                                        vehiculoDTO.getManufacturingDate(),
                                        vehiculoDTO.getNumberOfKilometers(),
                                        vehiculoDTO.getDoors(),
                                        vehiculoDTO.getPrice(),
                                        vehiculoDTO.getCurrency(),
                                        vehiculoDTO.getServices(),
                                        vehiculoDTO.getCountOfOwners());
        return vehiculo;
    }

    private List<VehiculoDTO> obtenerMapperVehiculos(List<Vehiculo> listaDeVehiculos){
        return listaDeVehiculos.stream().map(vehiculo -> {
            VehiculoDTO vehiculoDTO = new VehiculoDTO();
            vehiculoDTO.setBrand(vehiculo.getBrand());
            vehiculoDTO.setModel(vehiculo.getModel());
            vehiculoDTO.setManufacturingDate(vehiculo.getManufacturingDate());
            vehiculoDTO.setNumberOfKilometers(vehiculo.getNumberOfKilometers());
            vehiculoDTO.setDoors(vehiculo.getDoors());
            vehiculoDTO.setPrice(vehiculo.getPrice());
            vehiculoDTO.setCurrency(vehiculo.getCurrency());
            vehiculoDTO.setServices(vehiculo.getServices());
            vehiculoDTO.setCountOfOwners(vehiculo.getCountOfOwners());

            return vehiculoDTO;
        }).collect(Collectors.toList());
    }

    private List<VehiculoSinServiceDTO> obtenerMapperListaDeVehiculosSinService(List<Vehiculo> listaDeVehiculos){
        return listaDeVehiculos.stream().map(vehiculo -> {
            VehiculoSinServiceDTO vehiculoSinServiceDTO = new VehiculoSinServiceDTO();
            vehiculoSinServiceDTO.setBrand(vehiculo.getBrand());
            vehiculoSinServiceDTO.setModel(vehiculo.getModel());
            vehiculoSinServiceDTO.setManufacturingDate(vehiculo.getManufacturingDate());
            vehiculoSinServiceDTO.setNumberOfKilometers(vehiculo.getNumberOfKilometers());
            vehiculoSinServiceDTO.setDoors(vehiculo.getDoors());
            vehiculoSinServiceDTO.setPrice(vehiculo.getPrice());
            vehiculoSinServiceDTO.setCurrency(vehiculo.getCurrency());
            vehiculoSinServiceDTO.setCountOfOwners(vehiculo.getCountOfOwners());

            return vehiculoSinServiceDTO;
        }).collect(Collectors.toList());
    }
}
