package com.example.siniestros.repository;


import com.example.siniestros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {

}
