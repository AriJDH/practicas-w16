package com.ejercicio.miniserie.repository;

import com.ejercicio.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniseriRepository extends JpaRepository<MiniSerie,Long> {
}
