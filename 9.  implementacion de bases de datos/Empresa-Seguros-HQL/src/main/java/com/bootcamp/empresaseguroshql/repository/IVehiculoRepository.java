package com.bootcamp.empresaseguroshql.repository;

import com.bootcamp.empresaseguroshql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> encontrarPatenteVehiculos();

    //cast(v.anioFabricacion as java.lang.String ) as anio_fabricacion
    @Query("SELECT new map(v.patente as patente, v.marca as marca)  " +
            "FROM Vehiculo v " +
            "ORDER BY v.anioFabricacion")
    List<HashMap<String, String>> encontrarPatenteMarcaVehiculos();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = year(current_date())")
    List<String> encontrarVehiculoMas4RuedasAnioEnCurso();

    @Query("SELECT new map(v.patente as patente, v.marca as marca, v.modelo as modelo) " +
            "FROM Vehiculo v " +
            "JOIN Siniestro s ON s.vehiculoSiniestrado.id = v.id " +
            "WHERE s.perdidaEconomica > 10000")
    List<HashMap<String, String>> encontrarVehiculosPerdidaMayor10000();
}
