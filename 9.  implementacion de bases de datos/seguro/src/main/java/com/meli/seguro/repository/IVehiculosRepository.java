package com.meli.seguro.repository;

import com.meli.seguro.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVehiculosRepository extends JpaRepository<Vehiculo,Integer> {

    @Query("select v.patente from Vehiculo v")
    List<Vehiculo> listPatentes();

    @Query("select v.patente, v.marca from Vehiculo v order by v.año")
    List<Vehiculo> listAñoVehiculo();


    @Query("select v.patente from Vehiculo v where v.cantidadRuedas>4 and v.año=2022")
    List<Vehiculo> listarRuedas();

    @Query("select v.patente from Vehiculo  v join v.siniestros s where s.perdidaEconomica>10000.0")
    List<Vehiculo> listaSiniestrados();

    @Query("select v.patente, SUM(s.perdidaEconomica) as totalPerdida from Vehiculo  v join v.siniestros s where s.perdidaEconomica>10000.0 group by  v.patente ")
    List<Vehiculo> listaTotal();
}
