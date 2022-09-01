package com.example.movie_db.repository;

import com.example.movie_db.dto.EpisodeDTO;
import com.example.movie_db.model.Episode;
import com.example.movie_db.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode,Integer> {
    @Query("select e from Episode e where e.id in (Select ae.id from Actor a join a.episodes ae where a.id =:actor)")
    List<Episode> findEpisodeByActor(@Param("actor") int actor);
}
