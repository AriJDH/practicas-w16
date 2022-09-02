package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie,Long> {
    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>

}
