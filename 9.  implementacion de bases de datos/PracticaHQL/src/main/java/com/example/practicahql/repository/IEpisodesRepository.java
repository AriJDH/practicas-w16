package com.example.practicahql.repository;

import com.example.practicahql.model.Episode;
import com.example.practicahql.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodesRepository extends CrudRepository<Episode, Long> {

    @Query("select a.episodes from Actor a where  year(current_date) a.id = :actor")
    List<Episode> getEpisodesFromActor( Long actor);
}
