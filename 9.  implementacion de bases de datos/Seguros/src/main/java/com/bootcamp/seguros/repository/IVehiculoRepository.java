package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.dto.VehiculoSiniestro;
import com.bootcamp.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> getAllVehiculos();

    @Query("SELECT v.marca,v.patente FROM Vehiculo v ORDER BY v.anioFabricacion ASC")
    List<String> getAllPatentesYMarcasVehiculos();

    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and v.anioFabricacion = :anioFabricacion")
    List<String> getAllPatentesVehiculosFabricadosAnioCorrienteYMasDeCuatroRuedas(@Param("anioFabricacion") Integer anioFabricacion);

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<String> getVehiculosConSiniestrosDePerdidaMayorA10000Pesos();

    @Query("select new com.bootcamp.seguros.dto.VehiculoSiniestro(v, sum(s.perdidaEconomica)) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 group by v")
    List<VehiculoSiniestro> getVehiculosConSumaDePerdidasQueSuperaron10000Pesos();

}
