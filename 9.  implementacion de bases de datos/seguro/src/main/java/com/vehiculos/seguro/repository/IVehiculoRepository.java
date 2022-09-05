package com.vehiculos.seguro.repository;

import com.vehiculos.seguro.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar las patentes de todos los vehiculos registrados.
    @Query("select v from Vehiculo v")
    List<Vehiculo> findAllByPatente();

    // Listar la patente y marca de todos los vehiculos
    // ordenado por anio de fabricacion.
    @Query("select v from Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> findAllOrderByAnioFabricacion();

    // Listar la patente de todos los vehiculos con mas de 4 ruedas
    // que hayan sido en el corriente anio.
    @Query("select v from Vehiculo v " +
            "WHERE v.cantRuedas > 4 AND v.anioFabricacion = year(current_date)")
    List<Vehiculo> findAllWith4WheelsMadeThisYear();

    // Listar la matricula marca y modelo de todos los vehiculos
    // que hayan tenido un siniestro con perdida mayor de 10,000 pesos

}
