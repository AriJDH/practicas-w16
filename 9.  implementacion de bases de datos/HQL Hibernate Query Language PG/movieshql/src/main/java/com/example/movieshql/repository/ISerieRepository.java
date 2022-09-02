package com.example.movieshql.repository;

import com.example.movieshql.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ISerieRepository extends CrudRepository<Serie,Integer> {
    @Query("SELECT s, MAX(se.number) AS maximo FROM Serie s JOIN Season se ON (se.serie.id = s.id) GROUP BY s.id HAVING MAX(se.number) > :numberSeasons")
    List<Serie> getSerieByNumberSeasons(@Param("numberSeasons") Integer numberSeasons);

}
