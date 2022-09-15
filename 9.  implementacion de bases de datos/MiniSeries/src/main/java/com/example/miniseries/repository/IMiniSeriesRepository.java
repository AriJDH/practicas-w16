package com.example.miniseries.repository;

import com.example.miniseries.model.MiniSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSeriesRepository extends JpaRepository<MiniSeries, Long> {
}
