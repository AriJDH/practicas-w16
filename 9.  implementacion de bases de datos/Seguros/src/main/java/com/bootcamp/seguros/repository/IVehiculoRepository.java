package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> getAllVehiculos();

    @Query("SELECT v.marca,v.patente FROM Vehiculo v ORDER BY v.anioFabricacion ASC")
    List<String> getAllPatentesYMarcasVehiculos();

    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and v.anioFabricacion = :anioFabricacion")
    List<String> getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(@Param("anioFabricacion") Integer anioFabricacion);

}
