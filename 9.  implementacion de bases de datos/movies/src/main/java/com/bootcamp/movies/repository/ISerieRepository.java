package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie,Integer> {

    @Query("from Serie s where size(s.seasons)>:cantTemp")
    List<Serie> findSeriesBySeasonsGreaterThan(@Param("cantTemp") Integer cant);
}
