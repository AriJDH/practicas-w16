package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Integer> {
    @Query("select distinct e from Episode e join e.actors a where a.id = :actorId")
    List<Episode> findEpisodeByActors(@Param("actorId") Integer actorId);
}
