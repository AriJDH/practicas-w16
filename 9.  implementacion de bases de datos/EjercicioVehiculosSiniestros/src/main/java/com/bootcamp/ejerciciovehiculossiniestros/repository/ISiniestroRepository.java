package com.bootcamp.ejerciciovehiculossiniestros.repository;

import com.bootcamp.ejerciciovehiculossiniestros.model.Siniestro;
import com.bootcamp.ejerciciovehiculossiniestros.model.Vehiculo;
import com.bootcamp.ejerciciovehiculossiniestros.model.VehiculoSiniestro;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("select s.vehiculo from Siniestro s where s.perdida>10000")
    public List<Vehiculo> obtenerMarcaModeloYPatenteByPerdida();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("select sum(s.perdida) from Siniestro s where s.perdida>10000")
    public Double obtenerMarcaModeloYPatenteTotalPerdida();


    // Almacenar el resultado de la consulta en una lista de listas de dos elementos; el primero será un Vehículo y el segundo un Integer. Habrá que crear la clase VehiculoSiniestro con su correspondiente constructor.



}
