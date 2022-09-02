package com.ndemaio.ejercicioaseguradorahql.repository;

import com.ndemaio.ejercicioaseguradorahql.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
}
