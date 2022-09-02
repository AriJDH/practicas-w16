package com.vehiculo.api.repository;

import com.vehiculo.api.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("select v from Vehiculo v")
    List<Vehiculo> getAllVehiculos();


    @Query("select v from Vehiculo v order by v.anioFabricacion desc")
    List<Vehiculo> getAllVehiculosOrderByAnio();

    @Query("select v from Vehiculo v where v.cantidadRuedas = 4 and v.anioFabricacion = 2022 ")
    List<Vehiculo> getVehiculoByCantidadRuedasEqualsAndAnioFabricacion();

    @Query("select Vehiculo from Siniestro s join s.vehiculo Vehiculo where s.perdidaEconomica>10000")
    List<Vehiculo> getVehiculoWithBigSiniestro();

}
