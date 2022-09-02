package com.bootcamp.miniserie.repository;

import com.bootcamp.miniserie.entities.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
