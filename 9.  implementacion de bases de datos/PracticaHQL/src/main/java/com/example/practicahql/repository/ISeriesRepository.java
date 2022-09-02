package com.example.practicahql.repository;

import com.example.practicahql.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeriesRepository extends CrudRepository<Serie, Long> {

    @Query("select s.serie from Season s join s.serie serie group by serie having count(s) > :seasonsCount")
    public List<Serie> getSeriesWithSeasonsGreaterThan(Long seasonsCount);
}
