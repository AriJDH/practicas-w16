package com.tomas.concesionaria.repository;

import com.tomas.concesionaria.entity.Servicio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ServicioRepository implements IServicioRepository {

    HashMap<Long, List<Servicio>> tablaServicio = new HashMap<>();

    @Override
    public Long registrarServicio(List<Servicio> servicio) {

        Long indice = (long) (tablaServicio.size() + 1);
        tablaServicio.put(indice, servicio);

        Long idServicio = (long) tablaServicio.size();

        return idServicio;
    }

    @Override
    public List<Servicio> obtenerServicio(Long idServicio) {

        return tablaServicio.get(idServicio).stream().collect(Collectors.toList());


    }

}
