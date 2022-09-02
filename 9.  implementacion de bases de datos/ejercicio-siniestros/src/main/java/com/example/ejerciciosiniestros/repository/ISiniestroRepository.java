package com.example.ejerciciosiniestros.repository;

import com.example.ejerciciosiniestros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
