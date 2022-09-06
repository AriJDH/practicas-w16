package com.bootcamp.movies.repositories;

import com.bootcamp.movies.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEpisodesRepository extends JpaRepository<Episode,Long> {
    @Query("select e from Episode e join e.cast a where a.id = :actor_id")
    List<Episode> episodesWithActor(@Param("actor_id")Long actor);
}
