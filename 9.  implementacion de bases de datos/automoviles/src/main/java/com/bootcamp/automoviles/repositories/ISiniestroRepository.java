package com.bootcamp.automoviles.repositories;

import com.bootcamp.automoviles.entities.Siniestros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestros, Long> {
}
