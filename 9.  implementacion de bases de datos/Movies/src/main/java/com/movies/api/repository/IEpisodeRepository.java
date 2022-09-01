package com.movies.api.repository;

import com.movies.api.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Long> {

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor>
    @Query("select ep from Episode ep join ep.actors actor where actor.id = :actor_id")
    List<Episode> getEpisodesWhereActed(@Param("actor_id")Long actorId);

}
