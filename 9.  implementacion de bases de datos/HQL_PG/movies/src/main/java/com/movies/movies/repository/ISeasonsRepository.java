package com.movies.movies.repository;

import com.movies.movies.model.Seasons;
import com.movies.movies.model.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeasonsRepository extends CrudRepository<Seasons, Integer> {

    @Query("SELECT s.serie FROM Seasons s GROUP BY s.serie HAVING MAX(s.number) > :seasons")
    List<Series> getSeriesByGreateNumberSeasons(@Param("seasons") Integer seasons);
}
