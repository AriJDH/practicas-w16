package com.movies.api.repository;

import com.movies.api.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie,Long> {

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("select serie from Season s join s.serie serie group by serie having count(s) > :seasons_amount")
    List<Serie> getSeriesWithAmountOfSeasonsHigherThan(@Param("seasons_amount")Long anAmount);

}
