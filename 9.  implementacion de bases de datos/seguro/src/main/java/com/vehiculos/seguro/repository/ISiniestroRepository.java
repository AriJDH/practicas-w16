package com.vehiculos.seguro.repository;

import com.vehiculos.seguro.models.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

}
