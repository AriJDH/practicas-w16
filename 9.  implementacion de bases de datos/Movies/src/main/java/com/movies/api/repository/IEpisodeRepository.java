package com.movies.api.repository;

import com.movies.api.model.Episode;
import com.movies.api.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Long> {

    @Query("select e from Episode e join e.actors ea where ea.id = :actorId")
    List<Episode> findByActor(Long actorId);
}
