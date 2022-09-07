package com.example.hql.repository;

import com.example.hql.dto.PatenteDTO;
import com.example.hql.dto.StringX2;
import com.example.hql.dto.VehiculoIdDTO;
import com.example.hql.model.Vehiculo;
import com.example.hql.model.VehiculoBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryVehiculo extends JpaRepository<Vehiculo,Integer> {
    @Query("SELECT v.patente FROM Vehiculo v" )
    List<String> findPatenteAll();

    @Query("SELECT v from Vehiculo v order by v.anio_fabricacion")
    List<Vehiculo> findPatenteMarcaAll();

    @Query("SELECT v.patente FROM Vehiculo v where v.cantidad_ruedas > 4 AND v.anio_fabricacion =´2002´")
    List<String> findPatenteByAnioAndRuedas();

    @Query("SELECT v FROM Vehiculo v join v.siniestros vs where vs.perdida_economica > 10000")
    List<Vehiculo> findPatenteMarcaModeloBySiniestroPerdida();

    @Query("SELECT v.patente,v.marca,v.modelo, SUM(vs.perdida_economica) as perdida_Total FROM Vehiculo v join v.siniestros vs where vs.perdida_economica > 1000 ")
    List<VehiculoBD> findPatenteMarcaModeloBySiniestroPerdidaTotal();



}
