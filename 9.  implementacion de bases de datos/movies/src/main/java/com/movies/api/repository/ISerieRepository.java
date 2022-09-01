package com.movies.api.repository;

import com.movies.api.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie,Long> {

    @Query("select s from Serie s where s.seasons.size>:cantTemp")
    List<Serie> findSeriesBySeasonsGreaterThan(@Param("cantTemp") Integer cant);
}
