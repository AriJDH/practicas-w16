package com.bootcamp.ejerciciohql.repository;

import com.bootcamp.ejerciciohql.model.Actor;
import com.bootcamp.ejerciciohql.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository  extends CrudRepository<Serie, Long> {

    @Query("select serie from Season s join s.serie serie group by serie having count(s) > :numberOfSeasons")
    List<Serie> findSeriesWithNumberOfSeasons(Long numberOfSeasons);
}
