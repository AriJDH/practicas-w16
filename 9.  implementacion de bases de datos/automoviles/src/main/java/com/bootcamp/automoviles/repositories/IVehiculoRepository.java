package com.bootcamp.automoviles.repositories;


import com.bootcamp.automoviles.dto.VehiculoSiniestro;
import com.bootcamp.automoviles.dto.VehiculoSiniestroDTO;
import com.bootcamp.automoviles.entities.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculos, Long> {

    @Query("SELECT v FROM Vehiculos v")
    List<Vehiculos> findPatentes();
    @Query("SELECT  v FROM Vehiculos v ORDER BY v.anioFabricacion DESC")
    List<Vehiculos> findPatenteAndMarcaOrderByAnioFabricacionDESC();
    @Query("SELECT v FROM Vehiculos  v WHERE v.cantidadRuedas > 4 AND YEAR(v.anioFabricacion) = year(current_date())")
    List<Vehiculos> findMoreThan4Wheel();
    @Query("SELECT v  FROM Vehiculos v INNER JOIN Siniestros s ON s.vehiculos.id = v.id GROUP BY v.id HAVING (sum(s.perdidaEconomica)) > 10000")
    List<Vehiculos> findLostMoreThan10000();

    @Query("SELECT v, sum(s.perdidaEconomica) as perdida FROM Vehiculos v INNER JOIN Siniestros s ON s.vehiculos.id = v.id GROUP BY v.id HAVING (sum(s.perdidaEconomica)) > 10000")
    List<VehiculoSiniestro> findLostMoreThan10000Vehicule();

}
