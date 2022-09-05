package com.bootcamp.seguro.repository;

import com.bootcamp.seguro.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
    @Query("select distinct v from Vehiculo v join v.siniestros s where s.perdidaEconomica > 10000")
    List<Vehiculo> findAllBySiniestrosWherePerdidaEconomicaGreaterThan10000();

    @Query("select v from Vehiculo v where v.cantidadRuedas > 4 and v.anioFabricacion=year(current_date)")
    List<Vehiculo> findAllWhereCantidadRuedasGreaterThan4AndIsCurrentAnioFabricacion();
}
