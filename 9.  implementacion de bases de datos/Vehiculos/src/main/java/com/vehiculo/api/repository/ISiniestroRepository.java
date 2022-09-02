package com.vehiculo.api.repository;

import com.vehiculo.api.models.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
}
