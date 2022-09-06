package com.bootcamp.movies.repositories;

import com.bootcamp.movies.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeriesRepository extends JpaRepository<Series,Long> {

    @Query("select s from Series s join s.seasons where s.seasons.size > :seasons")
    List<Series> seriesBySeasonsGreaterThan(@Param("seasons")int seasonAmount);
}
