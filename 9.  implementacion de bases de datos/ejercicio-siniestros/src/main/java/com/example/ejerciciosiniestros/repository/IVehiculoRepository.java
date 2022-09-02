package com.example.ejerciciosiniestros.repository;

import com.example.ejerciciosiniestros.dto.PatenteMarcaDTO;
import com.example.ejerciciosiniestros.dto.VehiculoDTO;
import com.example.ejerciciosiniestros.dto.VehiculoPatenteDTO;
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
    List<PatenteMarcaDTO> getPatenteMarcaOrderByAnio();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas = 4 AND v.anoFabricacion = year(current_date())")
    List<VehiculoPatenteDTO> getPatenteAutosAnioActual();

    @Query("SELECT DISTINCT v.patente, v.marca, v.modelo FROM Siniestro s JOIN s.vehiculo v WHERE s.perdidaEconomica > 10000")
    List<VehiculoDTO> getVehiculosPerdida();

    @Query("SELECT SUM(s.perdidaEconomica) FROM Siniestro s WHERE s.perdidaEconomica > 10000")
    Double getTotalPerdidas();
}
