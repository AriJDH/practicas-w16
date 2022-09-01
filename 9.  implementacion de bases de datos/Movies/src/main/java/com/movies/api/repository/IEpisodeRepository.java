package com.movies.api.repository;

import com.movies.api.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Long> {

    @Query("select episode from Episode episode " +
            "join episode.actors a " +
            "where concat(a.firstName,' ',a.lastName)=:name")

    List<Episode> findAllBySerieAndActor(String name);
}
