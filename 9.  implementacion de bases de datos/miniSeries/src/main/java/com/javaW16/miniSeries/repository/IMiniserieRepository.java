package com.javaW16.miniSeries.repository;

import com.javaW16.miniSeries.model.MiniSerie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IMiniserieRepository extends JpaRepository <MiniSerie,Long>{

}
