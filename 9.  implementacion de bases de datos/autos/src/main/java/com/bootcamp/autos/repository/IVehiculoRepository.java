package com.bootcamp.autos.repository;

import com.bootcamp.autos.dto.VehiculoPatenteMarcaDto;
import com.bootcamp.autos.dto.VehiculoPatentesDto;
import com.bootcamp.autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v.patente from Vehiculo v")
    List<String> getPatentesVehiculos();

    @Query("select new map(v.patente as patente, v.marca as marca) from Vehiculo v order by v.anioFabricacion asc")
    List<HashMap<String, String>> getPatenteMarcaVehiculos();

    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and year(v.anioFabricacion) = year(current_date)")
    List<String> getPatentesByFechaByRuedaVehiculos();

    @Query("select new map(v.marca as marca, v.modelo as modelo) from Vehiculo v inner join v.siniestros s where s.perdidaEconomica > 10000.0")
    List<HashMap<String, String>> getVehiculosSiniestro();


    /*
        Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con
        pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    */
    @Query("select new map(v.marca as marca, v.modelo as modelo, sum(s.perdidaEconomica) as perdida) " +
            "from Vehiculo v inner join v.siniestros s where s.perdidaEconomica > 10000.0 group by s.vehiculo.id")
    List<HashMap<String, Object>> getVehiculosSiniestroTotalPerdida();
}
