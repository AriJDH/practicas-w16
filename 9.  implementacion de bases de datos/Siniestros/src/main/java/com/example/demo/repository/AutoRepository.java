package com.example.demo.repository;


import com.example.demo.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AutoRepository extends JpaRepository<Auto, Long> {

    @Query("select a from Auto a where a.id = :id")
    Auto getAutoById(@Param("id") Long id);

    @Query("select a from Auto a")
    List<Auto> getAutos();

    @Query("select a from Auto a order by a.anioFabricacion")
    List<Auto> getAutosOrderByAnioFabricacion();

    @Query("SELECT a " +
            "FROM Auto a, Siniestro s " +
            "Where s.auto = a.id AND " +
            "s.perdidaEconomica >= 10000")
    List<Auto> getAutosWithSiniestrosOver10000();

    //Ejemplo de mapeado dinamico
    @Query("select new map(a.patente as pat, a.marca as marc) from Auto a")
    HashMap<String, String> testMap();
}
