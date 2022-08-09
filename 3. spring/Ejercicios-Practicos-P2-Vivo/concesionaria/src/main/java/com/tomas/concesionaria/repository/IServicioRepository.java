package com.tomas.concesionaria.repository;

import com.tomas.concesionaria.entity.Servicio;

import java.util.List;

public interface IServicioRepository {

    Long registrarServicio(List<Servicio> servicio);
    List<Servicio> obtenerServicio(Long idServicio);

}
