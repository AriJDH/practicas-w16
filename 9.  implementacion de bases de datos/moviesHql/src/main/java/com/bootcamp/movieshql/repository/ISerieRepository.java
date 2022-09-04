package com.bootcamp.movieshql.repository;

import com.bootcamp.movieshql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {
    @Query("select se from Season s inner join s.serie se group by se.id having count(s.id) > :seasonsNumber")
    List<Serie> getCountSeasonsBySeries(@Param("seasonsNumber") Long seasonsNumber);

}
