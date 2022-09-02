package com.ndemaio.ejercicioaseguradorahql.service;

import com.ndemaio.ejercicioaseguradorahql.model.Vehiculo;
import com.ndemaio.ejercicioaseguradorahql.repository.VehiculoRepository;
import com.ndemaio.ejercicioaseguradorahql.repository.VehiculoSiniestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Object getVehiculosConSumaDePerdidasMayorA10000() {
        var objects = vehiculoRepository.getVehiculosConSumaDePerdidasDeAquellosQueSuperaron10000Pesos();
        return objects;
    }

    public List<String > getPatentesDeVehiculosRegistradasHoy() {
        var objects = vehiculoRepository.getPatentesDeVehiculosConMasDe4RuedasYFabricadosEn(LocalDate.now());
        return objects;
    }

    public List<String> getPatentesRegistradas() {
        var objects = vehiculoRepository.getPatentesRegistradas();
        return objects;
    }

    public List<String> getPatentesYMarcadsOrdenadasPorAnio() {
        var objects = vehiculoRepository.getPatentesYMarcasOrdenadosPorAnioFabricacion();
        return objects;
    }

    public Object getVehiculosConPerdidasMayorA10000() {
        var objects = vehiculoRepository.getVehiculosConSiniestrosDePerdidaMayorA10000Pesos();
        return objects;
    }

    public void createVehiculos() {
        var vehiculos = List.of(
                new Vehiculo(1l, "a", "a1", "a2", 1999, 4, new ArrayList<>()),
                new Vehiculo(2l, "a", "a1", "a2", 1999, 4, new ArrayList<>()),
                new Vehiculo(3l, "a", "a1", "a2", 1999, 4, new ArrayList<>()),
                new Vehiculo(4l, "a", "a1", "a2", 1999, 4, new ArrayList<>())
        );

        vehiculos.forEach(vehiculo -> vehiculoRepository.save(vehiculo));
    }
}
