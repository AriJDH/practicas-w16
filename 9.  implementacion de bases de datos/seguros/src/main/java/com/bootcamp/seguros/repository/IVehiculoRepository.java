package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("select v.patente from Vehiculo v")
    List<String> findAllPatentes();

    @Query("select v from Vehiculo v order by v.añoFabricacion")
    List<Vehiculo> findAllOrderByDate();

}
