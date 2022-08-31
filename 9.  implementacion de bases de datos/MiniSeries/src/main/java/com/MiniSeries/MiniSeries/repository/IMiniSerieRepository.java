package com.MiniSeries.MiniSeries.repository;

import com.MiniSeries.MiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository  extends JpaRepository <MiniSerie, Long> {
    
}
