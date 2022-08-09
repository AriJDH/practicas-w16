package com.tomas.concesionaria.repository;

import com.tomas.concesionaria.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehiculoRepository implements IVehiculoRepository{

    HashMap<Long, Vehiculo> tablaVehiculo = new HashMap<>();

    @Override
    public void registrarVehiculo(Vehiculo vehiculo) {

        Long indice = (long) (tablaVehiculo.size() + 1);
        tablaVehiculo.put(indice, vehiculo);

    }

    @Override
    public List<Vehiculo> obtenerVehiculo() {

        return tablaVehiculo.entrySet().stream()
                .map(x->x.getValue())
                .collect(Collectors.toList());

    }

    @Override
    public Vehiculo obtenerVehiculoEspecifico(Long id) {

        return tablaVehiculo.get(id);

    }

    @Override
    public Long consultarIdServicio(Long id) {
        return tablaVehiculo.get(id).getIdServicio();
    }


}
