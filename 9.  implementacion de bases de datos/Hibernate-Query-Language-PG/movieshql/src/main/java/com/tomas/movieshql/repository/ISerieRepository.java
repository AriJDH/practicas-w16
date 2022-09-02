package com.tomas.movieshql.repository;

import com.tomas.movieshql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface ISerieRepository extends JpaRepository<Serie, Long> {

    @Query("select s from Serie s where s.seasons.size>:amount")
    Set<Serie> findBySeriesMaxSeason(@Param("amount") int amountSeason);

}
