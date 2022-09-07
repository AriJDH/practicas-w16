package com.example.Aseguradora.Autos.repository;

import com.example.Aseguradora.Autos.model.Siniestro;
import com.example.Aseguradora.Autos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeniestroRepository extends JpaRepository<Siniestro,Integer> {

    @Query("SELECT SUM(s.perdidaEconomica) AS perdidaTotal FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 AND s.vehiculo.idVehiculo = v.idVehiculo ")
    Integer mostrarPorPerdidaEconomica();
}
