package com.ndemaio.ejercicioaseguradorahql.repository;

import com.ndemaio.ejercicioaseguradorahql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select veh.patente from Vehiculo veh")
    List<String> getPatentesRegistradas();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("select veh.patente, veh.marca from Vehiculo veh order by veh.anioFabricacion asc")
    List<String> getPatentesYMarcasOrdenadosPorAnioFabricacion();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("select veh.patente from Vehiculo veh where veh.cantidadDeRuedas > 4 and veh.anioFabricacion = :anio")
    List<String> getPatentesDeVehiculosConMasDe4RuedasYFabricadosEn(@Param("anio")LocalDate anio);

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<String> getVehiculosConSiniestrosDePerdidaMayorA10000Pesos();

    //Listar los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("select veh, sum(sin.perdidaEconomica)" +
            " FROM Vehiculo veh JOIN veh.siniestros sin WHERE sin.perdidaEconomica > 10000 group by veh")
    List<VehiculoSiniestro> getVehiculosConSumaDePerdidasDeAquellosQueSuperaron10000Pesos();

}
