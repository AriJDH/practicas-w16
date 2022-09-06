package com.bootcamp.movies.services;

import com.bootcamp.movies.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeriesRepository extends JpaRepository<Series, Long> {

    @Query("select serie from Season s join s.serie serie group by serie having count(s) > :seasons")
    List<Series> getSeriesWithAmountOfSeasonsHigherThan(@Param("seasons") Long anAmount);
}