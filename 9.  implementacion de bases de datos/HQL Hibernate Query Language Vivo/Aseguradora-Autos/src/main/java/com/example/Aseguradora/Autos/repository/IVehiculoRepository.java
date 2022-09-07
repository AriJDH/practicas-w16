package com.example.Aseguradora.Autos.repository;

import com.example.Aseguradora.Autos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Integer> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> mostrarPatentes();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> mostrarPatenteYMarca();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas>=4 AND v.anioFabricacion=2022")
    List<String> mostrarPatentePorRuedasYAnio();

    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> mostrarPatenteaMarcayModelo();


}
