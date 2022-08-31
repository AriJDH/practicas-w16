package com.example.miniserie.repository;

import com.example.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniSerieRepository  extends JpaRepository<MiniSerie,Long> {
}
