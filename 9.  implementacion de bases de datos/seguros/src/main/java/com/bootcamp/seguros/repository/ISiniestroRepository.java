package com.bootcamp.seguros.repository;


import com.bootcamp.seguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {


}
