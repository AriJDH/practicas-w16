package com.example.movies.Repositories;

import com.example.movies.Models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    @Query("SELECT s FROM Serie as s WHERE s.id IN (SELECT Count(se) FROM Season as se GROUP BY se.serie.id HAVING Count(se) >= :seasonCount)")
    List<Serie> findAllBySeasonCountGreaterThan(@Param("seasonCount") Integer seasonCount);
}
