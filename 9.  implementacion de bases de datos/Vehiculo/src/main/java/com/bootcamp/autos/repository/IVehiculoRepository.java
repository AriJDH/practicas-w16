package com.bootcamp.autos.repository;

import com.bootcamp.autos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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



}
