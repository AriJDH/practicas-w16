package com.example.movie_db.repository;

import com.example.movie_db.dto.SerieDTO;
import com.example.movie_db.model.Movie;
import com.example.movie_db.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Integer> {

    @Query("SELECT s FROM Serie s JOIN Season se ON s.id= se.serie.id group by se.serie.id having count (se.number) > :season")
    List<Serie> findSerieBySeason(@Param("season") Long season);
}
