package com.example.ejerciciohqlmoviesdb.repository;

import com.example.ejerciciohqlmoviesdb.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeriesRepository extends JpaRepository<Series,Integer> {


    @Query(value= "select s from Series s where s.id in (SELECT s.id from Series s inner join s.seasons seasons group by s.id having count(s.id) > :ammount)")
    List<Series> seriesWithmoreSeasonsThan(@Param("ammount") Long ammount);



    /*
    Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>

 */

}
