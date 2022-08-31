package com.example.springconcesionariadeautos.repository;

import com.example.springconcesionariadeautos.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiculoRepository implements IVehiculoRepository {
    private List<Vehiculo> listaDeVehiculos;

    public VehiculoRepository(){
        this.listaDeVehiculos = new ArrayList();
    }

    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
        vehiculo.setId(listaDeVehiculos.size() + 1);
        this.listaDeVehiculos.add(vehiculo);
        return vehiculo;
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return this.listaDeVehiculos;
    }

    @Override
    public Vehiculo obtenerVehiculo(int id) {
        return this.listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getId() == id).findFirst().orElse(null);
    }
}
