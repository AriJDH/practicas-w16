package com.example.siniestros.repository;

import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("SELECT v.patente FROM Vehiculo v where v.patente is not NULL")
    List<String> findAllPatentes();

    @Query("SELECT new com.example.siniestros.dto.PatenteMarcaDto(v.patente, v.marca) FROM Vehiculo v ORDER BY v.anioFabricacion DESC")
    List<PatenteMarcaDto> findAllPatentesAndMarcas();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantRuedas > 4 and year(v.anioFabricacion) = 2022")
    List<String> findAllPatentesWithMoreThanFourTuedasThisYear();


}
