package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie,Long> {
    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("select se from Season s join s.serie se group by se having count(se) > :quantity")
    List<Serie> findBySeasonQuantity(@Param("quantity") Long quantity);


}
