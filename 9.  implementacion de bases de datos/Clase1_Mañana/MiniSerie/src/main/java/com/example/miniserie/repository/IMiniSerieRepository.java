package com.example.miniserie.repository;

import com.example.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
