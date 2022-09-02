package com.bootcamp.ejerciciovehiculossiniestros.repository;

import com.bootcamp.ejerciciovehiculossiniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    @Query("select v.patente from Vehiculo v")
    public List<String> obtenerPatentes();
    @Query("select v from Vehiculo v where v.patente = :patente")
    public Vehiculo obtenerVehiculoPorPatente(@Param("patente") String patente);

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("select v from Vehiculo v order by v.anio")
    public List<Vehiculo> obtenerOrdenado();

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.

    @Query("select v from Vehiculo v where v.ruedas>3 and v.anio = year(current_date)")
    public List<Vehiculo> obtener4RuedasYAñoCorriente();



}
