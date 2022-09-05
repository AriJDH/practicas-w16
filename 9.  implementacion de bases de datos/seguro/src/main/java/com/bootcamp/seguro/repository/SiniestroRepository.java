package com.bootcamp.seguro.repository;

import com.bootcamp.seguro.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
    @Query("select s from Siniestro s where s.perdidaEconomica > 10000")
    List<Siniestro> findAllWherePerdidaEconomicaGreaterThan10000();
}
