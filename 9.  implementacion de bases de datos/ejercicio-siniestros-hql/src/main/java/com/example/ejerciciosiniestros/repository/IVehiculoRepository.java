package com.example.ejerciciosiniestros.repository;

import com.example.ejerciciosiniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getVehiculoPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anoFabricacion")
    List<>
}
